package JavaSe.File;
import java.io.*;
//字节输入流的最终写法
public class filelint02 {
    
    public static void main(String[] arga) {
    	FileInputStream fin=null;
    	int dataCount;
    	try {
			fin=new FileInputStream("test2");
			//这里使用byte数组来读取字节
			byte[] byte1=new byte[4];
			try {
				while((dataCount=fin.read(byte1))!=-1) {
					System.out.print(new String(byte1,0,dataCount));
				}//在这里的String类需要创建对象
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fin!=null) {
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

