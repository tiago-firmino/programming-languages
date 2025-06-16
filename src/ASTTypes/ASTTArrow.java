package ASTTypes;

public class ASTTArrow implements ASTType {
    ASTType dom;
    ASTType codom;

    public ASTTArrow(ASTType d, ASTType co) {
        dom = d;
        codom = co;
    }

    public ASTType getDom() {
        return dom;
    }
    
    public ASTType getCodom() {
        return codom;
    }

    public String toStr() {
        return dom.toStr()+"->"+codom.toStr();
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof ASTTArrow) {
            ASTTArrow other = (ASTTArrow) obj;
            return this.dom.equals(other.dom) && this.codom.equals(other.codom);
        }
        return false;

    }

    
}

