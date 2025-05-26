package IValues;
public class VBool implements IValue{

    boolean v;

    public VBool(boolean v0) {
        v = v0;
    }
    
    public boolean getval() {
        return v;
    }

    @Override
    public String toStr() {
        return Boolean.toString(v);
    }
    
    @Override
	public String toString() {
        return toStr();
    }

    VBool(VBool v0) {
        v = v0.v;
    }
}
