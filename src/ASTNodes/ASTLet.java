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
		Environment<IValue> env = e.beginScope();
		for (Bind b : decls) {
			String id = b.getId();
			ASTNode exp = b.getExp();
		  	env.assoc(id, exp.eval(env));
		}
		return body.eval(env);
	}

	
	public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
		Environment<ASTType> env = types.beginScope();
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
			if (b.getType() != null) {
				if (exp instanceof ASTLet || exp instanceof ASTFun) {
					env.assoc(id, b.getType());
					ASTType expType = exp.typecheck(env, names);
					if (!expType.equals(b.getType())) {
						throw new TypeCheckError("Type mismatch for variable " + id + ": expected " + expType.toStr() + ", found " + b.getType().toStr());
					}
				} else {
					ASTType expType = exp.typecheck(env, names);
					if (!expType.equals(b.getType())) {
						throw new TypeCheckError("Type mismatch for variable " + id + ": expected " + expType.toStr() + ", found " + b.getType().toStr());
					}
					env.assoc(id, b.getType());
				}
			} else {
				env.assoc(id, exp.typecheck(env, names));		
			}
		}

		return body.typecheck(env, names);
	}

}
