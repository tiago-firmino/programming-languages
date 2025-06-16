package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTSeq implements ASTNode {
    private final ASTNode first, second;

    public ASTSeq(ASTNode first, ASTNode second) {
        this.first = first;
        this.second = second;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        first.eval(env);
        return second.eval(env);
    }

    public String toStr() {
        return "(" + first + "; " + second + ")";
    }

    
    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType firstType = first.typecheck(e);
        ASTType secondType = second.typecheck(e);
        return secondType;
    }
}