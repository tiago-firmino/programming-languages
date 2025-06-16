package IValues;

public class VString implements IValue {

    String v;

    public VString(String v0) {
        v = v0;
    }

    public String getval() {
        return v;
    }

    @Override
    public String toStr() {
        return v;
    }
    
    @Override
	public String toString() {
        return toStr();
    }
    
}
