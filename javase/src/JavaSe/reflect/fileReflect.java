package JavaSe.reflect;
//反编译：只需要知道类名就可以反编译类的属性信息
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

//这里用反射机制来反编译Field
public class fileReflect {
	public static void main(String[] args) {
		StringBuilder s=new StringBuilder();
		//获取类
		try {
			Class studentClass=Class.forName("reflect.fieldStudent");
			int mod=studentClass.getModifiers();
			s.append(Modifier.toString(mod)+" class "+studentClass.getSimpleName()+"{\n\t");
		    //获取类的全部字段
			Field[] fields=studentClass.getDeclaredFields();
			for(Field fis:fields) {
				//获取修饰符
				int mod1=fis.getModifiers();
				//获取属性类型
				Class fieldType=fis.getType();
				//获取属性名字
				String fieldName=fis.getName();
				s.append(Modifier.toString(mod1)+" "+fieldType.getSimpleName()+" "+fieldName+";\n\t");
			}
			s.append("}");
			System.out.println(s);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
