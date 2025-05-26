package IValues;

public class VCons implements IValue {

    private final IValue head;
    private final IValue tail;

    public VCons(IValue head, IValue tail) {
        this.head = head;
        this.tail = tail;
    }

    public IValue getHead() {
        return this.head;
    }

    public IValue getTail() {
        return this.tail;
    }

    @Override
    public String toStr() {
        return String.format(
            "Cons(head=%s, tail=%s)",
            head.toStr(),
            tail.toStr()
        );
    }

    @Override
	public String toString() {
        return toStr();
    }
}