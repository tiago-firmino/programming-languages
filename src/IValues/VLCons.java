package IValues;

import Environment.*;
import ASTNodes.*;

public class VLCons implements IValue {
    private final ASTNode head;
    private final ASTNode tail;
    private IValue headValue;
    private IValue tailValue;
    private final Environment<IValue> env;

    public VLCons(ASTNode head, ASTNode tail, Environment<IValue> env) {
        this.head = head;
        this.tail = tail;
        this.headValue = null;
        this.tailValue = null;
        this.env = env;
    }

    public ASTNode getHead() {
        return this.head;
    }

    public ASTNode getTail() {
        return this.tail;
    }

    public Environment<IValue> getEnv() {
        return this.env;
    }

    public void setHeadValue(IValue headValue) {
        this.headValue = headValue;
    }
    
    public void setTailValue(IValue tailValue) {
        this.tailValue = tailValue;
    }

    @Override
    public String toStr() {
        if (headValue == null) {
            if (tailValue == null)
                return "LCons(suspended)";
            return String.format("LCons(headVal=suspended, tailVal=%s)", 
                tailValue.toStr());
        }
        return String.format(
            "LCons(headVal=%s, tailVal=%s)",
            headValue.toStr(),
            tailValue.toStr()
        );
    }

    @Override
	public String toString() {
        return toStr();
    }
}
