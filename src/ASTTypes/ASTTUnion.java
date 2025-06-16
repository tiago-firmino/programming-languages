package ASTTypes;

import java.util.*;
import Environment.*;
import Exception.*;

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

    public boolean equals(Object obj) {
        if (obj instanceof ASTTUnion) {
            ASTTUnion other = (ASTTUnion) obj;
            if (this.variants.size() != other.variants.size()) return false;
            for (Map.Entry<String, ASTType> entry : this.variants.entrySet()) {
                String key = entry.getKey();
                ASTType value = entry.getValue();
                if (!other.variants.containsKey(key) || !other.variants.get(key).equals(value)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public ASTType[] getTypes() {
        ASTType[] types = new ASTType[variants.size()];
        int i = 0;
        for (Map.Entry<String, ASTType> entry : variants.entrySet()) {
            types[i++] = entry.getValue();
        }
        return types;
    }

    @Override
    public ASTType unfold(Environment<ASTType> types) throws InterpreterError {
        
        TypeBindList lbls = new TypeBindList(new HashMap<>());
        for (Map.Entry<String, ASTType> entry : variants.entrySet()) {
            String key = entry.getKey();
            ASTType value = entry.getValue().unfold(types);
            lbls.add(key, value);
        }
        if (lbls.isEmpty()) return this;
        return new ASTTUnion(lbls);
    }

}
