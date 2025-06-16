package ASTTypes;
import java.util.*;


import Environment.*;
import Exception.*;

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

    public boolean equals(Object obj) {
        if (obj instanceof ASTTStruct) {
            ASTTStruct other = (ASTTStruct) obj;
            if (this.fields.size() != other.fields.size()) return false;
            for (Map.Entry<String, ASTType> entry : this.fields.entrySet()) {
                String key = entry.getKey();
                ASTType value = entry.getValue();
                if (!other.fields.containsKey(key) || !other.fields.get(key).equals(value)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    @Override
    public ASTType unfold(Environment<ASTType> types) throws InterpreterError {
        TypeBindList lbls = new TypeBindList(new HashMap<>());
        for (Map.Entry<String, ASTType> entry : fields.entrySet()) {
            String key = entry.getKey();
            ASTType value = entry.getValue().unfold(types);
            lbls.add(key, value);
        }
        if (lbls.isEmpty()) return this;
        return new ASTTStruct(lbls);
    }


}