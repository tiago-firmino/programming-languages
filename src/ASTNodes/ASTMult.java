package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public class ASTMult implements ASTNode {
	ASTNode lhs, rhs;

	public ASTMult(ASTNode l, ASTNode r) {
		lhs = l;
		rhs = r;
	}
	
	public IValue eval(Environment<IValue> e) throws InterpreterError {
		IValue v1 = lhs.eval(e);
		IValue v2 = rhs.eval(e);
		
		if (v1 instanceof VInt && v2 instanceof VInt) {
			int i1 = ((VInt) v1).getval();
			int i2 = ((VInt) v2).getval();
			return new VInt(i1 * i2);
		} else {
			throw new InterpreterError("illegal types to * operator");
		}
	}

	public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
		ASTType t1 = lhs.typecheck(types, names);
		if (t1 instanceof ASTTInt) {
			ASTType t2 = rhs.typecheck(types, names);
			if (t2 instanceof ASTTInt) {
				return t1;
			} else {
				throw new TypeCheckError("illegal type for * operator" + t2.toStr() + ", expected int");
			}
		} else {
			throw new TypeCheckError("illegal type for * operator" + t1.toStr() + ", expected int");
		}
	}


}
