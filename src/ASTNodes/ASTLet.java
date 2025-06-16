package ASTNodes;

import java.util.List;

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

	@Override
	public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
	}

}
