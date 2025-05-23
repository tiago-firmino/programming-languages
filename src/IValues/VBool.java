package IValues;
public class VBool implements IValue{

    boolean v;

    public VBool(boolean v0) {
        v = v0;
    }
    
    public boolean getval() {
        return v;
    }

    public boolean getBool() {
        return v;
    }

    public String toStr() {
        return Boolean.toString(v);
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
}
