package ASTTypes;

import java.util.Map;
import Environment.*;

public class ASTTUnion implements ASTType {
    public Map<String, ASTType> variants;

    public ASTTUnion(TypeBindList lbls) { this.variants = lbls.getMap(); }
    
    public String toStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (Map.Entry<String, ASTType> e : variants.entrySet()) {
            if (!first) sb.append(", ");
            sb.append(e.getKey()).append(": ").append(e.getValue().toStr());
            first = false;
        }
        sb.append("]");
        return sb.toString();
    }
}
