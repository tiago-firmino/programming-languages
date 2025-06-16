package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTSub implements ASTNode {
	ASTNode lhs, rhs;

	public ASTSub(ASTNode l, ASTNode r) {
		lhs = l;
		rhs = r;
	}
	
	public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v1 = lhs.eval(e);
		IValue v2 = rhs.eval(e);

		if (v1 instanceof VInt && v2 instanceof VInt) {
			return new VInt(((VInt) v1).getval() - ((VInt) v2).getval());
		} else {
			throw new InterpreterError("illegal types to - operator");
		}
	}

	
	public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
		ASTType t1 = lhs.typecheck(e);
		if (!(t1 instanceof ASTTInt)) {
			throw new TypeCheckError("left operand of - must be an integer, " + t1.toStr() + " found.");
		}
		ASTType t2 = rhs.typecheck(e);
		if (!(t2 instanceof ASTTInt)) {
			throw new TypeCheckError("right operand of - must be an integer, " + t2.toStr() + " found.");
		}
		return t1;			
	}


}
