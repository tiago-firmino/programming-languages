package ASTNodes;
import java.util.*;

import ASTTypes.*;
import Environment.*;
import IValues.*;
import Exception.*;

public class ASTTypeDef implements ASTNode {
    HashMap<String,ASTType> ltd;
    ASTNode body;

    public ASTTypeDef(HashMap<String,ASTType>  ltdp, ASTNode b) {
        ltd = ltdp;
        body = b;
    }
    
    public IValue eval(Environment<IValue> env) throws InterpreterError {
        return body.eval(env);
    }

    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        Environment<ASTType> newEnv = types.beginScope();
        for (Map.Entry<String, ASTType> entry : ltd.entrySet()) {
            String key = entry.getKey();
            ASTType value = entry.getValue();
            if (newEnv.find(key) != null) {
                throw new TypeCheckError("Type '" + key + "' already defined");
            }
            newEnv.assoc(key, value);
        }
        return body.typecheck(newEnv, names);
    }
}
