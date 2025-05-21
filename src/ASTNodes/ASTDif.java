package ASTNodes;

import Environment.*;
import IValues.*;
import Exception.*;

public class ASTDif implements ASTNode {
    private final ASTNode lhs;
    private final ASTNode rhs;

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
            throw new InterpreterError("== operator: integer or boolean expected, " + leftValue + " and " + rightValue + " found.");
        }
    }

    public String toStr() {
        return "(" + lhs + " != " + rhs + ")";
    }
    
}
