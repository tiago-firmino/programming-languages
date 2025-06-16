package ASTNodes;

import IValues.*;
import ASTTypes.*;
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
            if (((VBool) condVal).getval())
                return thenBr.eval(env);
            else
                return elseBr.eval(env);
        }
    }

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        ASTType condtyType = cond.typecheck(e);
        if (!(condtyType instanceof ASTTBool)) {
            throw new TypeCheckError("Condition of if-then-else must be a boolean, found: " + condtyType);
        }
        ASTType thenType = thenBr.typecheck(e);
        ASTType elseType = elseBr.typecheck(e);
        if (!thenType.equals(elseType)) {
            throw new TypeCheckError("Branches of if-then-else must have the same type, found: " + thenType + " and " + elseType);
        }
        return thenType;
    }
}