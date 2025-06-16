package ASTNodes;

import IValues.*;
import ASTTypes.*;
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
            return value;
        }
    }

    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        ASTType t = expr.typecheck(types, names);
        if (t instanceof ASTTInt || t instanceof ASTTBool || t instanceof ASTTString || t instanceof ASTTNil
            || t instanceof ASTTUnit || t instanceof ASTTArrow || t instanceof ASTTRef || t instanceof ASTTList
            || t instanceof ASTTUnion || t instanceof ASTTStruct || t instanceof ASTTId) {
            return t;
        } else {
            throw new TypeCheckError("Type error in print operation: type not found " + t.toStr());
        }
    }
}
