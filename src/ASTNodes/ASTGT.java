package ASTNodes;

import ASTTypes.*;
import Environment.*;
import IValues.*;
import Exception.*;

public class ASTGT implements ASTNode {
    private final ASTNode left, right;

    public ASTGT(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue leftValue = left.eval(env);
        IValue rightValue = right.eval(env);

        if (leftValue instanceof VInt && rightValue instanceof VInt) {
            return new VBool(((VInt) leftValue).getval() > ((VInt) rightValue).getval());
        } else {
            throw new InterpreterError("Invalid types for comparison: " + leftValue.toStr() + " and " + rightValue.toStr());
        }
    }

    @Override
    public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    } 
}
