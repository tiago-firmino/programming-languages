package ASTNodes;

import IValues.*;
import Environment.*;
import Exception.*;

public interface ASTNode {

	IValue eval(Environment<IValue> e) throws InterpreterError;

}
