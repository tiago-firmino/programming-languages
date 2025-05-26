package ASTNodes;

import Environment.*;
import IValues.*;
import Exception.*;

public class ASTAssign implements ASTNode {
    private final ASTNode lValue, rValue;

    public ASTAssign(ASTNode lValue, ASTNode rValue) {
        this.lValue = lValue;
        this.rValue = rValue;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue lVal = lValue.eval(env);
        if (!(lVal instanceof VCell)) {
            throw new InterpreterError("Assign: lValue is not a cell");
        } else {
            IValue rVal = rValue.eval(env);
            if (!(rVal instanceof IValue)) {
                throw new InterpreterError("Assign: rValue is not a value");
            }
            ((VCell) lVal).setValue(rVal);
            return rVal;
        }
    }
    
}
