package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTNot implements ASTNode {

    private ASTNode expr;

    public ASTNot(ASTNode expr) {
        this.expr = expr;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue value = expr.eval(e);
        if (value instanceof VBool) {
            return new VBool(!((VBool) value).getValue());
        } else {
            throw new InterpreterError("Invalid type for NOT operation");
        }
    }

    public String toStr() {
        return "not " + expr.toString();
    }

    public ASTNode getExpr() {
        return expr;
    }
    
}
