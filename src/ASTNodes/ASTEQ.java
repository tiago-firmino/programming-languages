package ASTNodes;

import Environment.*;
import IValues.*;
import Exception.*;

public class ASTEQ implements ASTNode {
    private ASTNode left, right;

    public ASTEQ(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue leftValue = left.eval(env);
        IValue rightValue = right.eval(env);

        if (leftValue instanceof VInt && rightValue instanceof VInt) {
            return new VBool(((VInt) leftValue).getval() == ((VInt) rightValue).getval());
        } else if (leftValue instanceof VBool && rightValue instanceof VBool) {
            return new VBool(((VBool) leftValue).getval() == ((VBool) rightValue).getval());
        } else {
            throw new InterpreterError("== operator: integer or boolean expected, " + leftValue + " and " + rightValue + " found.");
        }
    }
}
