package ASTTypes;

public class ASTTInt implements ASTType {
    
    public String toStr() {
        return "int";
    }
    
    public boolean equals(Object obj) {
        return obj instanceof ASTTInt;
    }

}


