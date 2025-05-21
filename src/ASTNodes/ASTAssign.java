package ASTNodes;

import Environment.*;
import IValues.*;
import Exception.*;

public class ASTAssign implements ASTNode {
    private final String id;
    private final ASTNode value;

    public ASTAssign(String id, ASTNode value) {
        this.id = id;
        this.value = value;
    }


    @Override
    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue val = value.eval(env);
        env.assoc(id, val);
        return val;
    }
    
}
