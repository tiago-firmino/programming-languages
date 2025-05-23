package ASTNodes;

import Environment.*;
import IValues.*;
import Exception.*;

public class ASTGTEQ implements ASTNode {
    
    private final ASTNode left;
    private final ASTNode right;

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
}