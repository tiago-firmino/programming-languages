package ASTTypes;

public class ASTTList implements ASTType {
    private ASTType elt;

    public ASTTList(ASTType eltt)
    {
        elt = eltt;
    }
    
    public String toStr() {
        return "list<"+elt.toStr()+">";
    }

    public boolean equals(Object obj) {
        //TODO
        return false;
    }

    
}
