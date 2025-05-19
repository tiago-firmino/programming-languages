public class ASTNil implements ASTNode {
    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return null;
    }

    public ASTNil() {
    }

    public String toStr() {
        return "nil";
    }
}
