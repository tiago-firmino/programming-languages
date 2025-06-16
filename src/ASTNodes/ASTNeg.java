package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTNeg implements ASTNode {
	ASTNode exp;

	public ASTNeg(ASTNode e) {
		exp = e;
	}

	public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v0 = exp.eval(e);
		
		if (v0 instanceof VInt) {
			return new VInt(-((VInt) v0).getval());
		} else {
			throw new InterpreterError("illegal types to neg operator");
		}
	}

	
	public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
		ASTType t = exp.typecheck(e);
		if (!(t instanceof ASTTInt)) {
			throw new TypeCheckError("neg operator: integer expected, " + t.toStr() + " found.");
		}
		return new ASTTInt();		
	}


}
