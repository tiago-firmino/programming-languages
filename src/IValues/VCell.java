package IValues;

public class VCell implements IValue {
    private IValue v;

    public VCell(IValue v0) {
        this.v = v0;
    }

    public IValue getval() {
        return v;
    }

    public void setValue(IValue v0) {
        this.v = v0;
    }
    
    @Override
    public String toStr() {
        return "VCell(" + v.toString() + ")";
    }
    
    @Override
	public String toString() {
        return toStr();
    }
}