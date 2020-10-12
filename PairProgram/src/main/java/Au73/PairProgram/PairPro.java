package Au73.PairProgram;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PairPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=args.length;
		int num,range;
		long startTime = 0,endTime = 0;
		if(i==4) {
			if(args[0]=="-n"&&args[2]=="-r") {//生成题目
				if(isNumeric(args[1])==true&&isNumeric(args[3])==true) {
					num=Integer.valueOf(args[1]);
					range=Integer.valueOf(args[3]);
					if(num>0&&range>0) {
						startTime = System.currentTimeMillis();
						GenerateItem.createitem(range, num);
						endTime = System.currentTimeMillis();
					}else {
						System.out.println("您输入的参数不合法！！！");
						System.exit(0);
					}

				}

	
			}else {
					System.out.println("您输入的参数不合法！！！");
					System.exit(0);
				}
		}else{
			System.out.println("您输入的参数数目不符合要求");
			System.exit(0);
		}



		System.out.println("");
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

	}
	
	
    //正则纯数字判断
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}