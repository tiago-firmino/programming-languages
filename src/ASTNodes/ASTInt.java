package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTInt implements ASTNode {
    int v;

    public ASTInt(int v0) {
        v = v0;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VInt(v);
    }

    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        return new ASTTInt();
    }

}
