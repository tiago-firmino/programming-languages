package ASTNodes;

import IValues.*;
import ASTTypes.*;
import Environment.*;
import Exception.*;

public interface ASTNode {

	IValue eval(Environment<IValue> e) throws InterpreterError;

	ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError;
}
