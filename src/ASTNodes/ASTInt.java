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

    @Override
    public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }

}
