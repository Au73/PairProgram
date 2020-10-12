package Au73.PairProgram;

public class FractionCalculation {
	
		public static String result(String nowOpera, String nowNum_1, String nowNum_2){
		
			
			String result = null;
			int mole_1, deno_1, mole_2, deno_2;
			String[] value_1 = change(nowNum_1);		
			mole_1 = Integer.parseInt(value_1[0]);
			deno_1 = Integer.parseInt(value_1[1]);
			String[] value_2 = change(nowNum_2);
			mole_2 = Integer.parseInt(value_2[0]);
			deno_2 = Integer.parseInt(value_2[1]);
			
			int flag = 0;
			if(nowOpera=="+") flag=1;
			else if(nowOpera=="-") flag=2;
			else if(nowOpera=="×") flag=3;
			else if(nowOpera=="÷") flag=4;
			
			switch (flag) {
			case 1:
				result = add(mole_1, deno_1, mole_2, deno_2);
				break;
			case 2:
				result = subtraction(mole_1, deno_1, mole_2, deno_2);
				break;
			case 3:
				result = multiplication(mole_1, deno_1, mole_2, deno_2);
				break;
			case 4:
				result = division(mole_1, deno_1, mole_2, deno_2);
				break;
			default:
				break;
		}			
		return result;			
	}	
	
		//加法
		public static String add(int a, int b, int c, int d) {
			int mole, deno;
			mole = a * d + c * b;
			deno = b * d;	
			return mole + "/" + deno;
		}
		
		
		//减法
		public static String subtraction(int a, int b, int c, int d){
			int mole, deno;
			mole = a * d - c * b;
			deno = b * d;
			return mole + "/" + deno;
					
		}
		
		
		//乘法
		public static String multiplication(int a, int b, int c, int d) {
			int mole, deno;
			mole = a * c;
			deno = b * d;
			return mole + "/" + deno;
		}
		
		
		//除法
		public static String division(int a, int b, int c, int d) {
			int mole, deno;
			mole = a * d;
			deno = b * c;
			return mole + "/" + deno;

		}
	
		
		//将分数转换成a/b形式并将a、b添加进array数组中
		public static String[] change(String num){
			String [] array = new String [2];
			if(num.contains("/")) {
				if(num.contains("'")) {//带分数
					String[] tarray = num.split("/|'");
					int[] sarray = new int[3];
					for(int i = 0;i<3;i++) {
						sarray[i] = Integer.parseInt(tarray[i]);
					}					
					array[0] = String.valueOf(sarray[0] * sarray[2] + sarray[1]);
					array[1] = String.valueOf(sarray[2]);			
				}else {					
					array = num.split("/");				
				}
			}else {
				array[0] = num;
				array[1] = "1";
			}
			return array;
		}
		
		
	
}
