package JavaSe.File;
import java.io.*;
public class filecopy01{
    public static void main(String[] args) {
    	FileInputStream fin=null;
    	FileOutputStream fis=null;
    	//边读边写
    	//读
    	try {
			fin=new FileInputStream("test1");
			fis=new FileOutputStream("test2");
			byte[] bytes=new byte[1024*1024];
			int readCount; 
			while((readCount=fin.read(bytes))!=-1) {
				fis.write(bytes, 0, readCount);}
			fis.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
			if(fin!=null) {
				try {
					fin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}


		}
    	
}
