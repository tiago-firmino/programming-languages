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

    @Override
    public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }
}
