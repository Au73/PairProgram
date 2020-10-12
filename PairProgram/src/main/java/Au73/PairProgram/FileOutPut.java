package Au73.PairProgram;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutPut {

	public static void FileOutPut(String str, int tag) {

		String path = "";
		if(tag == 1) {
			path = "D:\\Exercises.txt";
		}else if(tag == 2){
			path = "D:\\Answers.txt";
		}
		File file = new File(path);
		FileWriter fw;
		try {
			fw = new FileWriter(file,false);
			fw.write(str);
			fw.close();
			System.out.println("文件保存成功！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件保存不成功！");
		}
		
		


	}

}
