package ASTTypes;

import Environment.*;

public class ASTTUnit implements ASTType {
        
    public ASTTUnit() {
    }
    
    public String toStr() {
        return "()";
    }
    public boolean equals(Object obj) {
        return obj instanceof ASTTUnit;
    }

    @Override
    public ASTType unfold(Environment<ASTType> types) {
        return this;
    }

}