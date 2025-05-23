package ASTNodes;
import IValues.*;
import Environment.*;
import Exception.*;

public class ASTAnd implements ASTNode {
    private final ASTNode lhs;
    private final ASTNode rhs;

    public ASTAnd(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue left = lhs.eval(env);
        if (!(left instanceof VBool)) {
            throw new InterpreterError("&& operator: boolean expected, " + left + " found.");
        }
        if (((VBool) left).getval()) {
            IValue right = rhs.eval(env);
            if (!(right instanceof VBool)) {
                throw new InterpreterError("&& operator: boolean expected, " + right + " found.");
            }
            return new VBool(true && ((VBool) right).getval());
        }
        return new VBool(false);
    }


    public String toStr() {
        return "(" + lhs + " && " + rhs + ")";
    }
    
}
