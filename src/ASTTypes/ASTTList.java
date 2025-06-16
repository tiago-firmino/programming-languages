package ASTTypes;

import Environment.*;
import Exception.*;

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
        if (obj instanceof ASTTList) {
            ASTTList other = (ASTTList) obj;
            return elt.equals(other.elt);
        }
        return false;
    }

    public ASTType getHeadType() {
        return elt;
    }

    public ASTType getTailType() {
        return new ASTTList(elt);
    }

    @Override
    public ASTType unfold(Environment<ASTType> types) throws InterpreterError {
        ASTType unfoldedElt = elt.unfold(types);
        if (unfoldedElt == elt) {
            return this;
        }
        return new ASTTList(unfoldedElt);
    }

    
}
