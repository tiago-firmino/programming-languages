package ASTTypes;
import java.util.Map;

import Environment.*;

public class ASTTStruct implements ASTType {

    public Map<String, ASTType> fields;
    public ASTTStruct(TypeBindList lbls) { this.fields = lbls.getMap(); }
    public String toStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (Map.Entry<String, ASTType> e : fields.entrySet()) {
            if (!first) sb.append(", ");
            sb.append(e.getKey()).append(": ").append(e.getValue().toStr());
            first = false;
        }
        sb.append("}");
        return sb.toString();
    }

}