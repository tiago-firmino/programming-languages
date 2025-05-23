package ASTNodes;

import java.util.List;
import IValues.*;
import Environment.*;
import Exception.*;

public class ASTLet implements ASTNode {
	List<Bind> decls;
	ASTNode body;

	public IValue eval(Environment<IValue> e) throws InterpreterError {
		Environment<IValue> env = e; //.beginScope();
		for (Bind b : decls) {
			env = env.beginScope();
			String id = b.getId();
			ASTNode exp = b.getExp();
		  	env.assoc(id, exp.eval(env));
		}
		return body.eval(env);
	}

	public ASTLet(List<Bind> decls, ASTNode b) {
		this.decls = decls;
		body = b;
	}
}
