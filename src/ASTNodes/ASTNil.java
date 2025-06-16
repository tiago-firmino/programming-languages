package ASTNodes;

import IValues.*;
import Exception.*;
import ASTTypes.*;
import Environment.*;

public class ASTNil implements ASTNode {
    public ASTNil() {
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VNil();
    }
    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        return new ASTTNil();
    }
}
