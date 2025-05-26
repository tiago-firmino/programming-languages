package IValues;

public class VNil implements IValue {

    public VNil() {
    }

    @Override
    public String toStr() {
        return "nil";
    }
    
    @Override
	public String toString() {
        return toStr();
    }
}
