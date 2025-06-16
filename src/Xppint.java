import ASTNodes.*;
import ASTTypes.ASTType;
import Environment.*;
import IValues.*;

public class Xppint {

	public static void main(String args[]) {
		Parser parser = new Parser(System.in);
		ASTNode exp;

		System.out.println("X++ interpreter PL MEIC 2024/25\n");

		while (true) {
			try {
				System.out.print("# ");
				exp = Parser.Start();
				if (exp == null)
					System.exit(0);
				ASTType t = exp.typecheck(new Environment<ASTType>(), new Environment<ASTType>());
				System.out.println(t.toStr());
				IValue v = exp.eval(new Environment<IValue>());
				System.out.println(v.toStr());
			} catch (ParseException e) {
				System.out.println("Syntax Error.");
				Parser.ReInit(System.in);

			} catch (Exception e) {
				e.printStackTrace();
				parser.ReInit(System.in);
			}
		}
	}

}
