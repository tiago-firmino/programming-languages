package ASTTypes;
import Environment.*;

public class ASTTStruct implements ASTType {

    private TypeBindList ll;

    public ASTTStruct(TypeBindList llp) {
        ll = llp;
    }
    
    public String toStr() {
        return "union { ... }";
    }

}