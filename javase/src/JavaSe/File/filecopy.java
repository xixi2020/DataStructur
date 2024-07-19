package JavaSe.File;
import java.io.*;
public class filecopy {
     public static void main(String[] args) {
    	 //File中找出当前文件下所有目录名
    	 File file=new File("D:\\java");
    	 File[] files=file.listFiles();
    	/*
    	 for(File file1:files) {
    		 System.out.println(file.getAbsolutePath());//获得绝对路径
    	 }*/
    	 FileInputStream fin=null;
    	 FileOutputStream fis=null;
    	 try {
			fin=new FileInputStream(file.getAbsoluteFile());
			fis=new FileOutputStream("D:");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	 
     }
}
