package IValues;
public class VInt implements IValue {
	int v;

	public VInt(int v0) {
		v = v0;
	}

	VInt(VInt v0) {
		v = v0.v;
	}

	VInt(VBool v0) {
		v = v0.getval();
	}
	
	VInt(String v0) {
		v = Integer.parseInt(v0);
	}

	public int getval() {
		return v;
	}
	
	public String toStr() {
		return Integer.toString(v);
	}
}