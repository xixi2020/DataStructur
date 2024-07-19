package JavaSe.File;
import java.io.*;
//FileOututStream读范例
public class fileOut01 {
    public static void main(String[] args) {
    	FileOutputStream fis=null;
    	try {
    	fis=new FileOutputStream("myfile");//若项目中没有这个文件会自动新建
    	byte[] b= {1,2,3,4};
    	fis.write(b);//在这里不管myfile中有没有内容都会先把其中的内容清空后再写入
    	//只写一部分的话
    	//fis.write(b, 0, 2);
    	//若想在后面添加元素而不是取代的话且想添加字符串
    	String s="我是美女";
    	//将字符串转为数组
    	byte[] a=s.getBytes();
    	fis.write(a);
    	//读完后一定要flush：将通道内的未输出的剩余数据输出完（清空管道）
    	fis.flush();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}finally {
    		try {
    		if(fis!=null) {
    			fis.close();
    		}
    	}catch(IOException e){
    		e.printStackTrace();
    		}
    	}
    	//这里是试图将写入的文档再读出来
    	FileInputStream fin=null;
    	try {
			fin=new FileInputStream("myfile");
			int data;
			try {
				while((data=fin.read())!=-1) {
					//System.out.println(fin.read());这里不可以用fin.read()因为会再次调用会使
					//数组读取不全
					System.out.println(data);
				}
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
