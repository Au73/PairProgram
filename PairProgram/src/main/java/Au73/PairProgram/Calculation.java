package Au73.PairProgram;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculation {
	
	//设置运算符的优先级
	public static Map<String, Integer> map = new HashMap<String, Integer>() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 3684443232637633564L;

		{
			put("(", 0);
			put("+", 1);
			put("-", 1);
			put("×", 2);
			put("÷", 2);
			put(")", 3);
			put("=", 4);
		}
	};



	//将最终结果进行格式化
	public static String finalResult(String num) throws Exception {
		String[] nums = new String[2];
		int mole, deno;
		nums = FractionCalculation.change(num);
		mole = Integer.parseInt(nums[0]);
		deno = Integer.parseInt(nums[1]);
		String finalResult = FormatProcess.Format(mole, deno);
		if(finalResult.contains("-")) {//部分运算结果为负数
			throw new Exception();
		}else {
			return finalResult;
		}
		
	}
	
	
	// 括号内运算符的优先级是从低到高
	public static void doCalcul(Stack<String> operaStack, Stack<String> numStack, boolean flag) throws Exception {

		//将两个数值及运算符出栈进行计算
		String nowOpera = operaStack.pop();
		String nowNum_2 = numStack.pop();
		String nowNum_1 = numStack.pop();
		
		String result = FractionCalculation.result(nowOpera, nowNum_1, nowNum_2);			
		if(result.contains("-")) {	//结果为负										
			throw new Exception();
		}else {
			numStack.push(result);			
		}
		if(flag) {
			if("(".equals(operaStack.peek())) {//栈顶为（
				operaStack.pop();
			}else {
				doCalcul(operaStack, numStack, flag);//栈顶不为“（”
			}
		}else {
			if(!operaStack.empty()) {							
				doCalcul(operaStack, numStack, flag);
			}
		}
		
	}

	// 优先级比较
	public static void comparePriority(Stack<String> operaStack, Stack<String> numStack, String operator) throws Exception{
		
		
		String topOpera = operaStack.peek();
		int priority = map.get(operator) - map.get(topOpera);//优先级判断
		if (priority > 0) {
			operaStack.push(operator);
		} else {
			String nowOpera = operaStack.pop();
			String nowNum_2 = numStack.pop();
			String nowNum_1 = numStack.pop();
			String result = FractionCalculation.result(nowOpera, nowNum_1, nowNum_2);

			numStack.push(result);
			if (operaStack.empty()) {//运算符栈为空
				operaStack.push(operator);
			} else {
				comparePriority(operaStack, numStack, operator);
			}
		}

	}	
}
