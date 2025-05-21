package ASTNodes;

import Environment.*;
import IValues.*;
import Exception.*;

public class ASTGT implements ASTNode {

    private final ASTNode left;
    private final ASTNode right;
    private final String op;

    public ASTGT(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
        this.op = ">";
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue leftValue;
        IValue rightValue;
        leftValue = left.eval(env);
        rightValue = right.eval(env);
        if (leftValue instanceof VInt && rightValue instanceof VInt) {
            return new VBool(((VInt) leftValue).getval() > ((VInt) rightValue).getval());
        } else {
            throw new InterpreterError("Invalid types for comparison: " + leftValue.toStr() + " and " + rightValue.toStr());
        }
    }
    
    public String getOp() {
        return op;
    }    
}
