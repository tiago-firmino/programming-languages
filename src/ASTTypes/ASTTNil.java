package ASTTypes;

public class ASTTNil implements ASTType {

    @Override
    public String toStr() {
        return "nil";
    }

    public boolean equals(Object obj) {
        return obj instanceof ASTTNil;
    }

}

