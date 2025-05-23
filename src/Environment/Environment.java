package Environment;

import java.util.*;

import Exception.*;

public class Environment<E> { // Bind <String, Ivalue>
	Environment<E> anc;
	Map<String, E> bindings;

	public Environment() {
		anc = null;
		bindings = new HashMap<String, E>();
	}

	Environment(Environment<E> ancestor) {
		anc = ancestor;
		bindings = new HashMap<String, E>();
	}

	public Environment<E> beginScope() {
		return new Environment<E>(this);
	}

	Environment<E> endScope() {
		return anc;
	}

	public void assoc(String id, E bind) throws InterpreterError {
		if (bindings.containsKey(id)) {
			throw new InterpreterError("Identifier for variable" + id + " already exists in this scope.");
		} else {
			bindings.put(id, bind);
		}
	}

	void update(String id, E bind) throws InterpreterError {
		if (bindings.containsKey(id)) {
			bindings.put(id, bind);
		} else if (anc != null) {
			anc.update(id, bind);
		} else {
			throw new InterpreterError("Identifier " + id + " not found.");
		}
	}

	public E find(String id) throws InterpreterError {

		if (bindings.containsKey(id)) {
			return bindings.get(id);
		} else if (anc != null) {
			return anc.find(id);
		} else {
			throw new InterpreterError("Identifier " + id + " not found.");
		}
	}

}
