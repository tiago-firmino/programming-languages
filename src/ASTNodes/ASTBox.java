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

    @Override
    public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }
}