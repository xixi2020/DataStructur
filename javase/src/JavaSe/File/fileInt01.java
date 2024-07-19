package JavaSe.File;
import java.io.*;
//输入流的原始方法，一次一个字节效率低
public class fileInt01 {
	public static void main(String[] args) {
		FileInputStream fin = null;
		int data;
		try {
			/*fin=new FileInputStream("D:/新建文件夹/信管/eclipse/test.txt");//这里是绝对路径的情况下*/
			fin=new FileInputStream("test2");//这里为相对路径再eclipse是在项目中
			//这里不可以这样写应为最后为-1
			//这里不可以直接fin.read!=-1然后直接输出println(fin.read())
			//因为println(fin.read())中的fin.read()会再调用一次read方法，会再向前一个字节
			//所以输出会少
			/*while(fin.read()!=-1) {
				System.out.println(fin.read());//50 52 54 -1
			}*/
			while((data=fin.read())!=-1) {
				System.out.println(data);//49 50 51 52 53 54 55
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//这个方法是从Exception继承下来的，可以完整输出堆栈中的异常信息
		}
		finally {
			if(fin!=null) {//在这里不为null的情况下，前文必须将fin设为null
				try {
					fin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
