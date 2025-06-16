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

    @Override
    public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }
}
