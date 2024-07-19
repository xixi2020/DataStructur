package JavaSe.reflect;
//field：字段，也就是属性
//在这里测试用反射机制来获取类中的字段
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class filedStudentReflect {
    public static void main(String[] args) {
    	try {
    		//获取整个类
			Class studentClass=Class.forName("reflect.fieldStudent");
			//获取整个字段
			Field[] fields=studentClass.getFields();
			//获取字段属性的类型
			System.out.println(fields.length);
			//这里输出为1，代表这个方法只能获取类中的公共属性
			Field[] fs=studentClass.getDeclaredFields();
			//这里输出为3，代表这个方法可以获取类中所有的属性
			System.out.println(fs.length);
			//用遍历的方式来得到字段的各个属性
			for(Field field:fs) {
				//获取field的属性的类型
				Class fieldType=field.getType();
				String fName=fieldType.getSimpleName();//也可以是全名.getName
				//获取field字段的修饰符,在这里返回的是数据类型
				int fieldMod=field.getModifiers();
				//将数据类型转换为字符串类型，java.lang.reflect.Modifier中的方法（静态方法）
				String modifierString=Modifier.toString(fieldMod);
				System.out.println(fName+"----->"+modifierString);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
