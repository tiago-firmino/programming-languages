package IValues;

public class VCell implements IValue {
    private IValue v;

    public VCell(IValue v0) {
        this.v = v0;
    }

    public IValue getValue() {
        return v;
    }

    public void setValue(IValue v0) {
        this.v = v0;
    }

    public String toStr() {
        return "VCell(" + v.toString() + ")";
    }

    public IValue get() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}