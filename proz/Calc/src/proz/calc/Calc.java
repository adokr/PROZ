package proz.calc;

import jdk.jshell.JShell;


public class Calc implements ICalculator {
	
	private static final jdk.jshell.JShell js = JShell.create();

	private static double evaluate(String s) {

		{
			return 
			js.eval(s)
				.stream()
				.filter(e -> e.causeSnippet() == null)
				.filter(e -> e.status() == jdk.jshell.Snippet.Status.VALID)
				.mapToDouble(e -> Double.valueOf(e.value()))
				.sum();
		}
		
	}
	
	public double add(double x, double y) {
		
		return evaluate(String.valueOf(x) + '+' + String.valueOf(y));
	}
	
	public double sub(double x, double y) {
		
		return evaluate(String.valueOf(x) + '-' + String.valueOf(y));
	}
	
	public double mul(double x, double y) {
		
		return evaluate(String.valueOf(x) + '*' + String.valueOf(y));
	}
	
	public double div(double x, double y) {
		
		return evaluate(String.valueOf(x) + '/' + String.valueOf(y));
	}
	
	public double pow(double x, double y) {
		
		return evaluate("Math.pow(" + String.valueOf(x) + ", "  + String.valueOf(y) + ")");
	}
	
	public double log(double x, double y) {
		
		return evaluate("(Math.log(" + String.valueOf(y) + "))/(Math.log(" + String.valueOf(x) + "))");
	}
	
	public double mod(double x, double y) {
		
		return evaluate(String.valueOf(x) + '%' + String.valueOf(y));
	}
}
