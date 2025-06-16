package ASTNodes;

import ASTTypes.*;
import IValues.*;
import Environment.*;
import Exception.*;

/**
 * AST node representing field selection on a record, e.g. record.fieldName
 */
public class ASTFieldSelect implements ASTNode {
    private final ASTNode record;
    private final String field;

    public ASTFieldSelect(ASTNode record, String field) {
        this.record = record;
        this.field = field;
    }

    public ASTNode getRecord() {
        return record;
    }

    public String getField() {
        return field;
    }


    @Override
    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue recVal = record.eval(env);
        if (!(recVal instanceof VCell)) {
            throw new InterpreterError("Expected a struct for field access, got: " + recVal);
        }
        //VCell struct = (VCell) recVal;
        //if (!struct.hasField(field)) {
        //    throw new InterpreterError("Field '" + field + "' not found in struct");
        //}
        //return struct.getField(field);
        return null; // Placeholder for actual field access logic
    }

    @Override
    public ASTType typecheck(Environment<ASTType> typeEnv) throws TypeCheckError, InterpreterError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }
}