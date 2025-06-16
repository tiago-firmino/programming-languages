package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTFun implements ASTNode {
    String id;
    ASTNode body;
    ASTType paramType;
    
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

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        Environment<ASTType> newEnv;
        newEnv = e.beginScope();
        newEnv.assoc(id, paramType);
        ASTType bodyType = body.typecheck(newEnv);
        return new ASTTArrow(paramType, bodyType);
    }   
}
