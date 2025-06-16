package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTBox implements ASTNode {
    private final ASTNode expr;

    public ASTBox(ASTNode expr) {
        this.expr = expr;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue value = expr.eval(env);
        return new VCell(value);
    }

    
    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }
}