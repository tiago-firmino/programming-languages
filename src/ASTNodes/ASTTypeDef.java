package ASTNodes;
import java.util.*;

import ASTTypes.ASTType;
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

    public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
        Environment<ASTType> env = e.beginScope();
        Set<String> declareds = new HashSet<>();
        for (String id : ltd.keySet()) {
            if (declareds.contains(id)) {
                throw new TypeCheckError("Type " + id + " already declared in this scope.");
            }
            declareds.add(id);
            env.assoc(id, ltd.get(id));
        }
        return body.typecheck(env);
    }
}
