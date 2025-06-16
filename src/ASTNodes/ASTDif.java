package ASTNodes;

import ASTTypes.*;
import Environment.*;
import IValues.*;
import Exception.*;

public class ASTDif implements ASTNode {
    private final ASTNode lhs, rhs;

    public ASTDif(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue leftValue = lhs.eval(env);
        IValue rightValue = rhs.eval(env);

        if (leftValue instanceof VInt && rightValue instanceof VInt) {
            return new VBool(((VInt) leftValue).getval() != ((VInt) rightValue).getval());
        } else if (leftValue instanceof VBool && rightValue instanceof VBool) {
            return new VBool(((VBool) leftValue).getval() != ((VBool) rightValue).getval());
        } else {
            throw new InterpreterError("~= operator: integer or boolean expected, " + leftValue + " and " + rightValue + " found.");
        }
    }

    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        ASTType t1 = lhs.typecheck(types, names);
        ASTType t2 = rhs.typecheck(types, names);
        if (!((t1 instanceof ASTTUnit && t2 instanceof ASTTUnit) || (t1 instanceof ASTTNil && t2 instanceof ASTTNil) ||
            t1.getClass().equals(t2.getClass()))) {
            throw new TypeCheckError("~= operator: types do not match, " + t1.toStr() + " and " + t2.toStr() + " found.");
        }
        return new ASTTBool();
    }
}
