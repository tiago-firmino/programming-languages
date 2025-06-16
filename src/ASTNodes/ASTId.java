package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTId implements ASTNode {
    String id;

    public ASTId(String id) {
        this.id = id;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        return env.find(id);
    }

    @Override
    public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }

}
