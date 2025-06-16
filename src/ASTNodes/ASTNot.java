package ASTNodes;

import IValues.*;
import ASTTypes.*;
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
            return new VBool(!((VBool) value).getval());
        } else {
            throw new InterpreterError("Invalid type for NOT operation");
        }
    }

    
    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType t = expr.typecheck(e);
        if (t instanceof ASTTBool)
            return new ASTTBool();
        else
            throw new TypeCheckError("Type error in NOT operation: expected boolean, found " + t);
    }
}
