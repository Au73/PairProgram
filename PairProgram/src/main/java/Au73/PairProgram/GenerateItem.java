package Au73.PairProgram;



import java.util.Stack;

//生成题目及计算出答案
public class GenerateItem {

	public static void createitem(int range, int num) {


		String operator[] = { "+", "-", "×", "÷" };
		String allAnswer = "";	//全部答案
		String allItems = "";	//全部题目

		for(int i = 0;i < num;i++) {

			int operatornum = (int) (Math.random() * 3 + 1);
			String figure = null, operate = null;
			int undo = 0;
			int bracketnum = 0;
			String expression = "";
			boolean flag = true;
			String result;

			Stack<String> operaStack = new Stack<String>();
			Stack<String> numStack = new Stack<String>();



			try {
				// 未包含最后一个数
				while (operatornum > 0) {


					int tag = (int) (Math.random() * 2);			//用于判断是否要生成括号
					figure = FormatProcess.fraction(range);
					operate = operator[(int) (Math.random() * 4)];

					if (tag == 0 && bracketnum < operatornum - 1) {
						expression += "(";
						operaStack.push("(");
						bracketnum++;
						undo++;
						flag = false;
					} else if (tag == 1&& flag == true && undo > 0) {
						expression += figure + ")" + " " + operate + " ";
						numStack.push(figure);
						Calculation.doCalcul(operaStack, numStack, true);
						Calculation.comparePriority(operaStack, numStack, operate);
						operatornum--;
						undo--;
						flag = false;
					} else { 
						expression += figure + " " + operate + " ";
						if (operaStack.empty()) {
							operaStack.push(operate);
							numStack.push(figure);
						} else {
							numStack.push(figure);
							Calculation.comparePriority(operaStack, numStack, operate);
						}
						operatornum--;
						flag = true;
					}
				}


				// 添加最后一个数
				if (undo == 0) {
					figure = FormatProcess.fraction(range);

					expression += figure;
				} else if (undo == 1) {
					if (expression.startsWith("((") || expression.startsWith("(") && expression.contains(")") == false) {
						figure = FormatProcess.fraction(range);
						expression = expression.substring(1) + figure;
					} else {
						figure = FormatProcess.fraction(range);
						expression += figure + ")";

					}
				} else if (undo == 2) {
					if (expression.startsWith("((")) {
						figure = FormatProcess.fraction(range);
						expression = expression.substring(2) + figure;
					} else if (expression.startsWith("(")) {
						figure = FormatProcess.fraction(range);
						expression = expression.substring(1) + figure + ")";
					} else {
						figure = FormatProcess.fraction(range);
						expression += figure + "))";
					}
				}

				numStack.push(figure);
				Calculation.doCalcul(operaStack, numStack, false);
				result = Calculation.finalResult(numStack.peek());
				expression += " " + "=";
				if(expression.contains("÷ 0")) {
					i--;
					expression = "";
				}else {
					allItems +=   (i + 1) + "、  " + expression + "\n" ;
					allAnswer +=  (i + 1) + "、  " + result + "\n" ;



				}
			} catch (Exception e) {
				// TODO: handle exception
				i--;
			}

		}



		FileOutPut.FileOutPut(allItems, 1);
		FileOutPut.FileOutPut(allAnswer, 2);


	}
}

