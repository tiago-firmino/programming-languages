package ASTNodes;

import IValues.*;
import Exception.*;
import Environment.*;

public class ASTNil implements ASTNode {
    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VNil();
    }

    public ASTNil() {
    }
}
