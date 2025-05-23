package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTApp implements ASTNode {
    ASTNode func, arg;
    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue fValue = func.eval(env);

        if (!(fValue instanceof VClosure)) {
            throw new InterpreterError("app: closure expected, found " + fValue);
        }

        IValue argValue = arg.eval(env);
        VClosure clos = (VClosure) fValue;
        
        Environment<IValue> newEnv = clos.getEnv().beginScope();
        newEnv.assoc(clos.getParam(), argValue);
        IValue appValue = clos.getBody().eval(newEnv);
        return appValue;
    }

    public ASTApp(ASTNode func, ASTNode arg) {
        this.func = func;
        this.arg = arg;
    }
    
}
