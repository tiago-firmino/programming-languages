package ASTNodes;

import IValues.IValue;
import IValues.VCell;
import ASTTypes.*;
import Environment.Environment;
import Exception.InterpreterError;
import Exception.TypeCheckError;

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

    
    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }
}