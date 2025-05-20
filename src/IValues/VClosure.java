package IValues;

import Environment.*;
import ASTNodes.*;

public class VClosure implements IValue{
    
    private final Environment<IValue> env;
    private final String param;
    private final ASTNode body;

    public VClosure(Environment<IValue> env, String param, ASTNode body){
        this.env = env;
        this.param = param;
        this.body = body;
    }

    public Environment<IValue> getEnv() {
        return this.env;
    }

    public String getParam(){
        return this.param;
    }

    public ASTNode getBody() {
        return this.body;
    }

    public String toStr() {
        return String.format(
            "Closure(env=%s, param=%s, body=%s)",
            env,
            param,
            body
        );
    }

    public IValue call(IValue arg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'call'");
    }
    
}