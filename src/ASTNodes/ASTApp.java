package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTApp implements ASTNode {
    ASTNode func, arg;
    
    public ASTApp(ASTNode func, ASTNode arg) {
        this.func = func;
        this.arg = arg;
    }

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

    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        ASTType t1 = func.typecheck(types, names);
        if (!(t1 instanceof ASTTArrow)) {
            throw new TypeCheckError("app: function type expected, found " + t1.toStr());
        }
        ASTType t2 = arg.typecheck(types, names);
        ASTType dom = ((ASTTArrow) t1).getDom();

        if (!dom.equals(t2)) {
            throw new TypeCheckError("app: argument type " + t2.toStr() + " does not match function domain " + dom.toStr());
        }
        
        return ((ASTTArrow) t1).getCodom();

    }

    
}
