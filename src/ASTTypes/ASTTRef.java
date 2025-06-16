package ASTTypes;

public class ASTTRef implements ASTType {

    private ASTType type;

    public ASTTRef(ASTType type) {
        this.type = type;
    }
    
    public ASTType getType() {
        return type;
    }

    public String toStr() {
        return "ref<"+type.toStr()+">";
    }

    public boolean equals(Object obj) {
        if (obj instanceof ASTTRef) {
            ASTTRef other = (ASTTRef) obj;
            return this.type.equals(other.type);
        }
        return false;
    }
}