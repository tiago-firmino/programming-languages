package ASTNodes;

import java.util.List;
import IValues.*;
import Environment.*;
import Exception.*;
public class ASTMatch implements ASTNode {
	private final ASTNode value;
	private final List<VCell> cases;
	private final ASTNode defaultCase;

	public ASTMatch(ASTNode value, List<VCell> cases, ASTNode defaultCase) {
		this.value = value;
		this.cases = cases;
		this.defaultCase = defaultCase;
	}

	public IValue eval(Environment<IValue> env) throws InterpreterError {
		IValue val = value.eval(env);
		for (VCell matchCase : cases) {
			if (matchCase.get().equals(val)) {
				//return matchCase.get().eval(env);
			}
		}
		return defaultCase.eval(env);
	}

}