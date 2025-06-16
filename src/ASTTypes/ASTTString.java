package ASTTypes;

import Environment.*;

public class ASTTString implements ASTType {

    public ASTTString() {}

    public String toStr() {
        return "string";
    }

    public boolean equals(Object obj) {
        return obj instanceof ASTTString;
    }

    @Override
    public ASTType unfold(Environment<ASTType> types) {
        return this;
    }

}
