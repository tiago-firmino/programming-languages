package IValues;

public class VUnit implements IValue {
    
    @Override
    public String toStr() {
        return "()";
    }
    
    @Override
	public String toString() {
        return toStr();
    }
}
