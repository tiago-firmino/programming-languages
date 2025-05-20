package ASTNodes;

import java.util.List;
import IValues.*;
import Environment.*;
import Exception.*;
public class ASTMatch implements ASTNode {

    private final ASTNode scrutinee;    // the expression being matched
    private final ASTNode nilCase;      // branch for nil → N
    private final String headId;        // name bound to head in (x :: l)
    private final String tailId;        // name bound to tail in (x :: l)
    private final ASTNode consCase;     // branch for (x :: l) → R
    private final int line, col;        // for precise error reporting

    public ASTMatch(ASTNode scrutinee,
                    ASTNode nilCase,
                    String headId,
                    String tailId,
                    ASTNode consCase,
                    int line,
                    int col) {
        this.scrutinee = scrutinee;
        this.nilCase   = nilCase;
        this.headId    = headId;
        this.tailId    = tailId;
        this.consCase  = consCase;
        this.line      = line;
        this.col       = col;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue v = scrutinee.eval(env);

        //if (v instanceof VLazyCons) {
        //    VLazyCons lazy = (VLazyCons) v;
        //    IValue head = lazy.forceHead();
        //    IValue tail = lazy.forceTail();
        //    v = new VCons(head, tail);
        //    lazy.updateTo(v);
        //}
//
        //if (v instanceof VNil) {
        //    return nilCase.eval(env);
//
        //} else if (v instanceof VCons) {
        //    VCons cons = (VCons) v;
//
        //    Environment<IValue> scope = env.beginScope();
        //    scope.assoc(headId, cons.getHead());
        //    scope.assoc(tailId, cons.getTail());
//
        //    return consCase.eval(scope);
//
        //} else {
        //    throw new InterpreterError(
        //        "Line " + line + ", col " + col +
        //        ": match on non-list value " + v.toStr());
        //}
        return v;
    }
}