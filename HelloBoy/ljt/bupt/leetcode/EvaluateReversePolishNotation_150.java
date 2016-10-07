package ljt.bupt.leetcode;

import java.util.LinkedList;

public class EvaluateReversePolishNotation_150 {

	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		int res = evalRPN(tokens);
		System.out.println(res);
	}

	private static int evalRPN(String[] tokens) {
		if(tokens.length==0 || tokens==null)
			return 0;
		LinkedList<String> stack = new LinkedList<>();
		int a1 = 0,a2 =0 ;
		for (int i = 0; i < tokens.length; i++) {
			switch (tokens[i]) {
			case "+":
				a1 = Integer.parseInt(stack.removeFirst());
				a2 = Integer.parseInt(stack.removeFirst());
				a1 += a2;
				stack.addFirst(a1+"");
				break;
			case "-":
				a1 = Integer.parseInt(stack.removeFirst());
				a2 = Integer.parseInt(stack.removeFirst());
				a2 -= a1;
				stack.addFirst(a2+"");
				break;
			case "*":
				a1 = Integer.parseInt(stack.removeFirst());
				a2 = Integer.parseInt(stack.removeFirst());
				a1 *= a2;
				stack.addFirst(a1+"");
				break;
			case "/":
				a1 = Integer.parseInt(stack.removeFirst());
				a2 = Integer.parseInt(stack.removeFirst());
				a2 /= a1;
				stack.addFirst(a2+"");
				break;
			default:
				stack.addFirst(tokens[i]);
				break;
			}

		}
		return Integer.parseInt(stack.removeFirst());
	}

}
