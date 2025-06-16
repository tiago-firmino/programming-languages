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

public boolean isEmpty() {
    return lbl.isEmpty();
}

public void add(String key, ASTType value) {
    if (lbl.containsKey(key)) {
        throw new IllegalArgumentException("Key " + key + " already exists in the TypeBindList.");
    }
    lbl.put(key, value);
} 
}