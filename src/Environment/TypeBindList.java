package Environment;

import java.util.*;
import ASTTypes.*;

public class TypeBindList  {

private HashMap<String,ASTType> lbl;

public TypeBindList(HashMap<String,ASTType> ll) {
        lbl = ll;
}

public Map<String, ASTType> getMap() {
    return lbl;
} 
}