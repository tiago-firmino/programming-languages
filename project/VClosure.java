import java.util.List;

public class VClosure implements IValue {

    private final Environment<IValue> env;
    private final String name;
    private final List<String> params;
    private final ASTNode body;

    public VClosure(Environment<IValue> env, String name, List<String> params, ASTNode body) {
        this.env = env;
        this.name = name;
        this.params = params;
        this.body = body;
    }
    
    public IValue call(IValue arg) throws InterpreterError {
        Environment<IValue> callEnv = env.beginScope();

        callEnv.assoc(name, this);
        callEnv.assoc(params.get(0), arg);

        return body.eval(callEnv);
    }


    public Environment<IValue> getEnv() {
        return env;
    }

    public String getName() {
        return name;
    }

    public List<String> getParams() {
        return params;
    }

    public ASTNode getBody() {
        return body;
    }

    public String toStr() {
        return "<closure fn " + name + "(" + String.join(", ", params) + ")>";
    }
}
