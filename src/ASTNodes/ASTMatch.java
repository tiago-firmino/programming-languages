package ASTNodes;

import IValues.*;
import Exception.*;
import ASTTypes.*;
import Environment.*;

public class ASTMatch  implements ASTNode {

    private final ASTNode target, nilBranch, consBranch;
    private final String headId, tailId;

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
        IValue targetVal= target.eval(env);
        if (targetVal instanceof VNil) {
            return nilBranch.eval(env);

        } else if (targetVal instanceof VCons) {
            VCons consValue = (VCons) targetVal;
            Environment<IValue> consEnv = env.beginScope();
            consEnv.assoc(headId, consValue.getHead());
            consEnv.assoc(tailId, consValue.getTail());
            return consBranch.eval(consEnv);

        } else if (targetVal instanceof VLCons) {
            VLCons lazyConsValue = (VLCons) targetVal;
            Environment<IValue> consLEnv = lazyConsValue.getEnv();
            IValue headVal = lazyConsValue.getHead().eval(consLEnv);
            IValue tailVal = lazyConsValue.getTail().eval(consLEnv);

            lazyConsValue.setHeadValue(headVal);
            lazyConsValue.setTailValue(tailVal);
            
            env = env.beginScope();
            env.assoc(headId, headVal);
            env.assoc(tailId, tailVal);

            return consBranch.eval(env);
        } else {
            throw new InterpreterError("invalid target value: " + targetVal);
        }
    }

    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        ASTType targetType = target.typecheck(types, names);
        ASTType elementType;

        if (targetType instanceof ASTTList) {
            elementType = ((ASTTList) targetType).getHeadType();
        } else if (targetType instanceof ASTTUnion) {
            throw new TypeCheckError("Union types in match not well implemented");
        } else {
            throw new TypeCheckError("Match expression requires a list; found: " + targetType.toStr());
        }

        ASTType nilType = nilBranch.typecheck(types, names);

        Environment<ASTType> consEnv = types.beginScope();
        consEnv.assoc(headId, elementType);
        consEnv.assoc(tailId, new ASTTList(elementType));
        ASTType consType = consBranch.typecheck(consEnv, names);

        if (!nilType.equals(consType)) {
            throw new TypeCheckError(String.format("Type mismatch in match cases: 'nil' has type %s, but 'cons' has type %s.",
            nilType.toStr(), consType.toStr()));
        }

        return nilType;
    }
}
