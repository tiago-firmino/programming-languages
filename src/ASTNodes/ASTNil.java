package ASTNodes;

import IValues.*;
import Exception.*;
import ASTTypes.*;
import Environment.*;

public class ASTNil implements ASTNode {
    
    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VNil();
    }

    public ASTNil() {
    }

    
    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        return new ASTTNil();
    }
}
