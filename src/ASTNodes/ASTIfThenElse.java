package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTIfThenElse implements ASTNode {
    private final ASTNode cond, thenBr, elseBr;

    public ASTIfThenElse(ASTNode cond, ASTNode thenBr, ASTNode elseBr) {
        this.cond   = cond;
        this.thenBr = thenBr;
        this.elseBr = elseBr;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue condVal = cond.eval(env);

        if (!(condVal instanceof VBool)) {
            throw new InterpreterError("Condition must be a boolean: " + condVal.toStr());
        } else {
            if (((VBool) condVal).getval()) {
                return thenBr.eval(env);
            } else {
                return elseBr.eval(env);
            }
        }
    }
}