package ASTTypes;

import Environment.*;

public class ASTTBool implements ASTType {

    public ASTTBool() {
    }

    public String toStr() {
        return "bool";
    }

    public boolean equals(Object obj) {
        return obj instanceof ASTTBool;
    }

    @Override
    public ASTType unfold(Environment<ASTType> types) {
       return this;
    }
}