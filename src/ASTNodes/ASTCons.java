package ASTNodes;

import IValues.*;
import Exception.*;
import Environment.*;

public class ASTCons implements ASTNode {

    private final ASTNode head;
    private final ASTNode tail;

    public ASTCons(ASTNode head, ASTNode tail) {
        this.head = head;
        this.tail = tail;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
    
        IValue headValue = head.eval(env);
        IValue tailValue = tail.eval(env);
        if (!(tailValue instanceof VCons || tailValue instanceof VNil)) {
            throw new InterpreterError("invalid value, since head is " + headValue + "tail cannot be: " + tailValue);
        }
        return new VCons(headValue, tailValue);

    }

    public ASTNode getHead() {
        return this.head;
    }

    public ASTNode getTail() {
        return this.tail;
    }
}
