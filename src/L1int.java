import ASTNodes.*;
import Environment.*;
import IValues.*;

public class L1int {

	public static void main(String args[]) {
		Parser parser = new Parser(System.in);
		ASTNode exp;

		System.out.println("L1 interpreter PL MEIC 2024/25 (v0.0)\n");

		while (true) {
			try {
				System.out.print("# ");
				exp = Parser.Start();
				if (exp == null)
					System.exit(0);
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
