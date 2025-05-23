package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTBox implements ASTNode {
    private final ASTNode expr;

    public ASTBox(ASTNode expr) {
        this.expr = expr;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        // lazy box ⇒ a thunk
        IValue value = expr.eval(env);
        return new VCell(value);
    }

    public String toStr() {
        return "box(" + expr + ")";
    }
}