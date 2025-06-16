package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTBool implements ASTNode {
    private final boolean value;

    public ASTBool(boolean value) {
        this.value = value;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        return new VBool(value);
    }

    @Override
    public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }
}