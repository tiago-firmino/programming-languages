public class ASTWhile implements ASTNode {

    private ASTNode condition;
    private ASTNode body;

    public ASTWhile(ASTNode condition, ASTNode body) {
        this.condition = condition;
        this.body = body;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        while (condition.eval(e) instanceof VBool && ((VBool) condition.eval(e)).getValue()) {
            body.eval(e);
        }
        return null;
    }

    public String toStr() {
        return "while " + condition.toString() + " do " + body.toString();
    }

    public ASTNode getCondition() {
        return condition;
    }

    public ASTNode getBody() {
        return body;
    }
    
}
