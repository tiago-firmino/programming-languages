import src.Environment.Environment;
import src.Exception.InterpreterError;

package src.IValues;
class VCell implements IValue {
    private final Environment<IValue> env;
    private final ASTNode expr;
    private IValue cached;
    private boolean evaluated;

    public VCell(Environment<IValue> env, ASTNode expr) {
        this.env = env;
        this.expr = expr;
        this.evaluated = false;
    }

    public Environment<IValue> getEnv() {
        return env;
    }
    public ASTNode getExpr() {
        return expr;
    }
    public boolean isEvaluated() {
        return evaluated;
    }
    public IValue get() throws InterpreterError {
        if (!evaluated) {
            cached = expr.eval(env);
            evaluated = true;
        }
        return cached;
    }

    public String toStr() {
        return evaluated ? cached.toStr() : "<cell>";
    }
}