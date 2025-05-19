public class ASTOr implements ASTNode {
    private final ASTNode lhs;
    private final ASTNode rhs;

    public ASTOr(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue left = lhs.eval(env);
        if (left instanceof VBool) {
            if (((VBool) left).getValue()) {
                return left;
            }
        } else {
            throw new InterpreterError("|| operator: boolean expected, " + left + " found.");
        }
        return rhs.eval(env);
    }

    public String toStr() {
        return "(" + lhs + " || " + rhs + ")";
    }
    
}
