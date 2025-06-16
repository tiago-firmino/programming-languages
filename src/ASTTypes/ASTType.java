package ASTTypes;

import Environment.*;
import Exception.*;

public interface ASTType  {
    String toStr();

    boolean equals(Object o);

    ASTType unfold(Environment<ASTType> types) throws InterpreterError;
}


