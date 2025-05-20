package ASTNodes;
import IValues.*;
import Environment.*;
import Exception.*;

public class ASTAnd implements ASTNode {
    private final ASTNode lhs;
    private final ASTNode rhs;

    public ASTAnd(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue left = lhs.eval(env);
        if (left instanceof VBool) {
            if (((VBool) left).getValue()) {
                return rhs.eval(env);
            } else {
                return new VBool(false);
            }
        } else {
            throw new InterpreterError("&& operator: boolean expected, " + left + " found.");
        }
    }

    public String toStr() {
        return "(" + lhs + " && " + rhs + ")";
    }
    
}
