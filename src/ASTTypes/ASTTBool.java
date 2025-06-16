package ASTTypes;

public class ASTTBool implements ASTType {

    public ASTTBool() {
    }

    public String toStr() {
        return "bool";
    }

    public boolean equals(Object obj) {
        return obj instanceof ASTTBool;
    }
}