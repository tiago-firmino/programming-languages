package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public class ASTWhile implements ASTNode {
    private ASTNode condition, body;

    public ASTWhile(ASTNode condition, ASTNode body) {
        this.condition = condition;
        this.body = body;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue condVal;
        while (true) {
            condVal = condition.eval(e);
            if (!(condVal instanceof VBool)) {
                throw new InterpreterError("illegal types to while condition: " + condVal.toStr());
            } else {
                if (!((VBool) condVal).getval()) {
                    break;
                } else {
                    body.eval(e);
                }
            }

        }
        return condVal;
    }
}
