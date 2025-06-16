package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTOr implements ASTNode {
    private final ASTNode lhs, rhs;

    public ASTOr(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue left = lhs.eval(env);
        IValue right = rhs.eval(env);

        if (left instanceof VBool && right instanceof VBool) {
            return new VBool(((VBool) left).getval() || ((VBool) right).getval());
        } else {
            throw new InterpreterError("illegal types for || operator");
        }
    }
    
    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType t1 = lhs.typecheck(e);
        if (!(t1 instanceof ASTTBool))
            throw new TypeCheckError("left operand of || must be a boolean");
        ASTType t2 = rhs.typecheck(e);
        if (!(t2 instanceof ASTTBool))
            throw new TypeCheckError("right operand of || must be a boolean");
        return new ASTTBool();
    }
}
