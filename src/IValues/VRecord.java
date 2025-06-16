package IValues;

import Environment.*;
import Exception.*;

public class VRecord implements IValue {
    private final String id;
    private final Environment<IValue> fields;

    public VRecord(String id, Environment<IValue> fields) {
        this.id = id;
        this.fields = fields;
    }

    public String getId() {
        return id;
    }

    public IValue getField(String fieldName) throws InterpreterError {
        
        if (fieldName == null || fieldName.isEmpty()) {
            throw new InterpreterError("Field name cannot be null or empty");
        }
        return fields.find(fieldName);

    }

    @Override
    public String toStr() {
        return String.format("%s.%s)", id, fields);
    }

    @Override
	public String toString() {
        return toStr();
    }
    
}
