package ASTNodes;

import IValues.*;
import Exception.*;
import Environment.*;

public class ASTCons implements ASTNode {

    private final ASTNode head;
    private final ASTNode tail;
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
                throw new InterpreterError("invalid value, since tail is " + tailValue + " head cannot be: " + headValue);
            }
            if (!(tailValue instanceof IValue)) {
                throw new InterpreterError("invalid value, since head is " + headValue + " tail cannot be: " + tailValue);
            }
            return new VCons(headValue, tailValue);

        }
    }
}
