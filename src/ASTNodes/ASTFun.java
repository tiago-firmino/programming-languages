package ASTNodes;

import java.util.List;
import IValues.*;
import Environment.*;
import Exception.*;

public class ASTFun implements ASTNode {
    ASTNode body;
    String id;
    List<String> args;

    public IValue eval(Environment<IValue> env) throws InterpreterError {

        Environment<IValue> funEnv = env.beginScope();

        //VClosure closure = new VClosure(funEnv, id, args, body);

        //funEnv.assoc(id, closure);

        //return closure;
        return null;
    }

    public ASTFun(String id, List<String> args, ASTNode b) {
        this.id = id;
        this.args = args;
        body = b;
    }
}
