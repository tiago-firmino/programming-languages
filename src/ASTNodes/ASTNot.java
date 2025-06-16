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

    @Override
    public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }
}
