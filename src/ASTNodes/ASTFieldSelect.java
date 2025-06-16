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


    
    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue recValue = record.eval(env);
        if (!(recValue instanceof VRecord)) {
            throw new InterpreterError("Expected a record, but got: " + recValue);
        }
        VRecord recordValue = (VRecord) recValue;
        IValue fieldValue = recordValue.getField(field);
        if (fieldValue == null) {
            throw new InterpreterError("Field '" + field + "' not found in record");
        }
        return fieldValue;
    }

    
    public ASTType typecheck(Environment<ASTType> types, Environment<ASTType> names) throws TypeCheckError, InterpreterError {
        throw new UnsupportedOperationException("Unimplemented method 'typecheck'");
    }
}