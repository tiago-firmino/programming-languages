public class ASTPrintln implements ASTNode {

    private ASTNode expr;

    public ASTPrintln(ASTNode expr) {
        this.expr = expr;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue value = expr.eval(e);
        System.out.println(value.toString() + "\n");
        return value;
    }

    public String toStr() {
        return "println " + expr.toString();
    }

    public ASTNode getExpr() {
        return expr;
    }
    
}
