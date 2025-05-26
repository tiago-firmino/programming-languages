package ASTNodes;

import IValues.IValue;
import IValues.VCell;
import Environment.Environment;
import Exception.InterpreterError;

public class ASTDeref implements ASTNode {
    private final ASTNode expr;

    public ASTDeref(ASTNode expr) {
        this.expr = expr;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue v = expr.eval(env);
        if (!(v instanceof VCell))
            throw new InterpreterError("deref: cell or ref expected, found " + v); 
        else
            return ((VCell) v).getval();
    }
}