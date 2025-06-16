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

    
    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType t = e.find(id);
        if (t == null) {
            throw new TypeCheckError("Identifier '" + id + "' not found in environment");
        }
        return t;
    }

}
