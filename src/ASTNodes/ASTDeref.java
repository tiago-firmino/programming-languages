public class ASTDeref implements ASTNode {
    private final ASTNode expr;


    public ASTDeref(ASTNode expr) {
        this.expr = expr;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue v = expr.eval(env);
        if (v instanceof VCell) {
            return ((VCell) v).get();
        }   
        else if (v instanceof VCell) {
            return ((VCell) v).get();
        } else {
            throw new InterpreterError("deref: cell or ref expected, found " + v);
        }
    }

    public String toStr() {
        return "*(" + expr + ")";
    }
}