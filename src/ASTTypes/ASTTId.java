package ASTTypes;

public class ASTTId implements ASTType	{	

    String id;	
    
    public ASTTId(String id)	{
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public String toStr() {
        return id;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ASTTId)
            return this.getId().equals(((ASTTId) obj).getId());
        return false;
    }


}	
