package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTPlus implements ASTNode {
	ASTNode lhs, rhs;

	public ASTPlus(ASTNode l, ASTNode r) {
		lhs = l;
		rhs = r;
	}

	public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v1 = lhs.eval(e);
		
		if (v1 instanceof VInt) {
			IValue v2 = rhs.eval(e);
			if (v2 instanceof VInt) {
				int i1 = ((VInt) v1).getval();
				int i2 = ((VInt) v2).getval();
				return new VInt(i1 + i2);
			}

		}
		throw new InterpreterError("illegal types to + operator");
	}

	
	public ASTType typecheck(Environment<ASTType> e) throws TypeCheckError, InterpreterError {
		ASTType t1 = lhs.typecheck(e);
		if (!(t1 instanceof ASTTInt)) {
			throw new TypeCheckError("left operand of + must be an integer, " + t1.toStr() + " found.");
		}
		ASTType t2 = rhs.typecheck(e);
		if (!(t2 instanceof ASTTInt)) {
			throw new TypeCheckError("right operand of + must be an integer, " + t2.toStr() + " found.");
		}
		return new ASTTInt();
		
	}


}
