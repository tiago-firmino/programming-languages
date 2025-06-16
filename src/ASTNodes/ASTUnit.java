package ASTNodes;

import ASTTypes.*;
import Environment.*;
import IValues.*;
import Exception.*;

public class ASTUnit implements ASTNode {
    public ASTUnit() {
    }

    public IValue eval(Environment<IValue> env) {
        return new VUnit();
    }

    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        return new ASTTUnit();
    }
    
}
