package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTFun implements ASTNode {
    String id;
    ASTNode body;
    
    public ASTFun(String id, ASTNode b) {
        this.id = id;
        this.body = b;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        return new VClosure(env, id, body);
    }


    public void setBody(ASTNode b) {
        this.body = b;
    }   
}
