package ASTNodes;

import java.util.*;

import ASTTypes.*;
import IValues.*;
import Environment.*;
import Exception.*;

public class ASTLet implements ASTNode {
	List<Bind> decls;
	ASTNode body;

	public ASTLet(List<Bind> decls, ASTNode b) {
		this.decls = decls;
		body = b;
	}
	
	public IValue eval(Environment<IValue> e) throws InterpreterError {
		Environment<IValue> env = e;
		for (Bind b : decls) {
			env = env.beginScope();
			String id = b.getId();
			ASTNode exp = b.getExp();
		  	env.assoc(id, exp.eval(env));
		}
		return body.eval(env);
	}

	
	public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
		Environment<ASTType> env = e.beginScope();
		Set<String> declareds = new HashSet<>();
		for (Bind b : decls) {
			String id = b.getId();
			if (declareds.contains(id)) {
				throw new TypeCheckError("Variable " + id + " already declared in this scope.");
			}
			declareds.add(id);
		}
		for (Bind b : decls) {
			String id = b.getId();
			ASTNode exp = b.getExp();
			env.assoc(id, exp.typecheck(env));		
		}

		return body.typecheck(env);
	}

}
