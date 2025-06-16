package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTBool implements ASTNode {
    private final boolean value;

    public ASTBool(boolean value) {
        this.value = value;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        return new VBool(value);
    }

    
    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        return new ASTTBool();
    }
}