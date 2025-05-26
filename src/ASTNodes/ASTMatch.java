package ASTNodes;

import IValues.*;
import Exception.*;
import Environment.*;

public class ASTMatch  implements ASTNode {

    private final ASTNode target;
    private final ASTNode nilBranch;
    private final String headId;
    private final String tailId;
    private final ASTNode consBranch;

    public ASTMatch(ASTNode target,
                    ASTNode nilBranch,
                    String headId, String tailId,
                    ASTNode consBranch) {
        this.target = target;
        this.nilBranch = nilBranch;
        this.headId = headId;
        this.tailId = tailId;
        this.consBranch = consBranch;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue targetVal= this.target.eval(env);
        if (targetVal instanceof VNil) {
            return this.nilBranch.eval(env);
        } else if (targetVal instanceof VCons) {
            VCons consValue = (VCons) targetVal;
            Environment<IValue> consEnv = env.beginScope();
            consEnv.assoc(headId, consValue.getHead());
            consEnv.assoc(tailId, consValue.getTail());
            return this.consBranch.eval(consEnv);
        } else {
            throw new InterpreterError("invalid target value: " + targetVal);
        }
    }
}
