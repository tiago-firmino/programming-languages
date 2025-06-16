package ASTTypes;

import Environment.*;

public class ASTTInt implements ASTType {
    
    public String toStr() {
        return "int";
    }
    
    public boolean equals(Object obj) {
        return obj instanceof ASTTInt;
    }

    @Override
    public ASTType unfold(Environment<ASTType> types) {
        return this;
    }

}


