package ASTNodes;

import ASTTypes.*;
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

    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        ASTType lValueType = lValue.typecheck(types, names);
        if (!(lValueType instanceof ASTTRef)) {
            throw new TypeCheckError("Assign: lValue must be a reference type, found " + lValueType.toStr());
        }
        
        ASTType rValueType = rValue.typecheck(types, names);
        ASTTRef refType = (ASTTRef) lValueType;
        
        if (!rValueType.equals(refType.getType())) {
            throw new TypeCheckError("Assign: type mismatch, expected " + refType.getType().toStr() + ", found " + rValueType.toStr());
        }
        
        return rValueType;
    }
    
}
