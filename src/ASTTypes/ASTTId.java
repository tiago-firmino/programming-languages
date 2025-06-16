package ASTTypes;

import Environment.*;
import Exception.*;

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

    @Override
    public ASTType unfold(Environment<ASTType> types) throws InterpreterError {
        ASTType type = types.find(id);
        if (type == null) {
            throw new InterpreterError("Unbound type variable: " + id);
        }
        return type.unfold(types);
    }


}	
