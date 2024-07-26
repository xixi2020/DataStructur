package JavaSe.JavaWorryTest;

import java.util.Scanner;

//这里演示一个Scanner的bug
public class ScannerBug {
    public static void main(String  args[]) {
    	Scanner in=new Scanner(System.in);
    	System.out.println("输入年龄");
    	int age=in.nextInt();
    	//这里会有一个\n符存在
    	//在这里Scanner是面对字符流输出所以nextint只读非数字为止，返回数字后，调用nextLine
    	//此时的nextline刚好读到 \n，返回" "
    	in.nextLine();//将剩下的\n读完
    	System.out.println("输入名字");
        String name=in.nextLine();
    	System.out.printf("Hello %s,age %d\n",name,age);
   //结果为输入名字
   //Hello ,age 3 不允许输入姓名，输入年龄后直接显示输出
    }
}
