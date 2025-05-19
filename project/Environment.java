import java.util.*;

public class Environment<E> { // Bind <String, Ivalue>
	Environment<E> anc;
	Map<String, E> bindings;

	Environment() {
		anc = null;
		bindings = new HashMap<String, E>();
	}

	Environment(Environment<E> ancestor) {
		anc = ancestor;
		bindings = new HashMap<String, E>();
	}

	Environment<E> beginScope() {
		return new Environment<E>(this);
	}

	Environment<E> endScope() {
		return anc;
	}

	void assoc(String id, E bind) throws InterpreterError {
		if (bindings.containsKey(id)) {
			throw new InterpreterError("Identifier " + id + " already exists.");
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

	E find(String id) throws InterpreterError {

		if (bindings.containsKey(id)) {
			return bindings.get(id);
		} else if (anc != null) {
			return anc.find(id);
		} else {
			throw new InterpreterError("Identifier " + id + " not found.");
		}
	}

}
