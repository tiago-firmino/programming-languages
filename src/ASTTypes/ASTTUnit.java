package ASTTypes;

public class ASTTUnit implements ASTType {
        
    public ASTTUnit() {
    }
    
    public String toStr() {
        return "()";
    }
    public boolean equals(Object obj) {
        return obj instanceof ASTTUnit;
    }

}