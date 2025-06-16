package ASTNodes;

import ASTTypes.*;
import Environment.*;
import IValues.*;
import Exception.*;

public class ASTGTEQ implements ASTNode {
    private final ASTNode left, right;
    
    public ASTGTEQ(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }
    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue leftValue = left.eval(env);
        IValue rightValue = right.eval(env);

        if (leftValue instanceof VInt && rightValue instanceof VInt) {
            return new VBool(((VInt) leftValue).getval() >= ((VInt) rightValue).getval());
        } else {
            throw new InterpreterError("Invalid types for comparison: " + leftValue.toStr() + " and " + rightValue.toStr());
        }
    }
    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        ASTType t1 = left.typecheck(types, names);
        ASTType t2 = right.typecheck(types, names);
        if (!(t1 instanceof ASTTInt) || !(t2 instanceof ASTTInt)) {
            throw new TypeCheckError(">= operator: types do not match, " + t1.toStr() + " and " + t2.toStr() + " found.");
        }
        return new ASTTBool();
    }
}