package IValues;
public class VInt implements IValue {
	int v;

	public VInt(int v0) {
		v = v0;
	}

	public int getval() {
		return v;
	}
	
	@Override
	public String toStr() {
		return Integer.toString(v);
	}
	
	@Override
	public String toString() {
        return toStr();
    }

	VInt(VInt v0) {
		v = v0.v;
	}
}