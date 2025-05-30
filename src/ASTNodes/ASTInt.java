package ASTNodes;

import IValues.*;
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

}
