package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTApp implements ASTNode {
    ASTNode lhs, rhs;
    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue arg = rhs.eval(env);
        IValue fun = lhs.eval(env);
        if (fun instanceof VClosure) {
            VClosure clos = (VClosure) fun;
            return clos.call(arg);
        } else throw new InterpreterError("app: closure expected, found "+fun);
    }

    public ASTApp(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    
}
