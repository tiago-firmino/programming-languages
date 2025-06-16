package ASTNodes;

import IValues.*;
import Exception.*;
import ASTTypes.*;
import Environment.*;

public class ASTCons implements ASTNode {
    private final ASTNode head, tail;
    private final boolean lazyCons;

    public ASTCons(ASTNode head, ASTNode tail, boolean lazyCons) {
        this.head = head;
        this.tail = tail;
        this.lazyCons = lazyCons;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        if (lazyCons) {
            return new VLCons(head, tail, env);
        } else {
            IValue headValue = head.eval(env);
            IValue tailValue = tail.eval(env);
            if (!(headValue instanceof IValue)) {
                throw new InterpreterError("invalid value for head: " + headValue);
            }
            if (!(tailValue instanceof IValue)) {
                throw new InterpreterError("invalid value for tail " + tailValue);
            }
            return new VCons(headValue, tailValue);

        }
    }

    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        ASTType headType = head.typecheck(types, names);
        return new ASTTList(headType);
    }
}
