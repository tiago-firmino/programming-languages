package IValues;
public class VBool implements IValue{

    boolean v;

    public VBool(boolean v0) {
        v = v0;
    }

    VBool(int v0) {
        v = (v0 != 0);
    }

    VBool(String v0) {
        v = (v0.equals("true"));
    }

    VBool(VBool v0) {
        v = v0.v;
    }

    VBool(VInt v0) {
        v = (v0.getval() != 0);
    }
    
    public int getval() {
        return v ? 1 : 0;
    }

    public String toStr() {
        return Boolean.toString(v);
    }

    public boolean getValue() {
        return v;
    }
}
