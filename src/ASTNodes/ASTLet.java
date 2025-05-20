package ASTNodes;

import java.util.List;
import IValues.*;
import Environment.*;
import Exception.*;

public class ASTLet implements ASTNode {
	List<Bind> decls;
	ASTNode body;

	public IValue eval(Environment<IValue> e) throws InterpreterError {
		Environment<IValue> en = e.beginScope();
		//for (Bind p : decls) {
		//	String id = p.getId();
		//	ASTNode exp = p.getExp();
		//  	en.assoc(id, exp.eval(en));
		//}
		//;
		//System.out.println("go body");
		return body.eval(en);
	}

	public ASTLet(List<Bind> decls, ASTNode b) {
		this.decls = decls;
		body = b;
	}
}
