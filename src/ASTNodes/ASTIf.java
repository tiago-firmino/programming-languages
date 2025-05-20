package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTIf implements ASTNode {
    private final ASTNode cond, thenBr, elseBr;

    public ASTIf(ASTNode cond, ASTNode thenBr, ASTNode elseBr) {
        this.cond   = cond;
        this.thenBr = thenBr;
        this.elseBr = elseBr;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue v = cond.eval(env);
        if (((VBool) v).getValue()) {
            return thenBr.eval(env);
        } else {
            return elseBr.eval(env);
        }
    }

    public String toStr() {
        return "if " + cond + " then " + thenBr + " else " + elseBr;
    }
}