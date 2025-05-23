package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTPrint implements ASTNode {

    private ASTNode expr;
    private boolean isLn = false;

    public ASTPrint(ASTNode expr, boolean isLn) {
        this.expr = expr;
        this.isLn = isLn;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue value = expr.eval(e);
        if (!(value instanceof IValue)) {
            throw new InterpreterError("illegal types to print: " + value.toStr());
        } else {
            if (!isLn)
                System.out.print(value.toString());
            else 
                System.out.println(value.toString());
        }
        
        return value;
    }

    public ASTNode getExpr() {
        return expr;
    }
    
    public boolean isLn() {
        return isLn;
    }
}
