package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTId implements ASTNode {

    String id;

    public ASTId(String id) {
        this.id = id;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        //System.out.println("Env " + env);
        return env.find(id);
    }

}
