public class ASTPrint implements ASTNode {

    private ASTNode expr;

    public ASTPrint(ASTNode expr) {
        this.expr = expr;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue value = expr.eval(e);
        System.out.println(value.toString());
        return value;
    }

    public String toStr() {
        return "print " + expr.toString();
    }

    public ASTNode getExpr() {
        return expr;
    }
}
