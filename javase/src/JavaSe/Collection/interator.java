package JavaSe.Collection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class interator {
	public static void main(String[] args) {
	Collection a=new ArrayList();
	a.add("123");
	a.add("456");
	a.add("def");
	a.add(new Object());
	Iterator it=a.iterator();
	while(it.hasNext()) {//hasnext和next都是iterator中的方法
		Object obj=it.next();//不管存进去是什么类型，最后都是obj类型
		System.out.println(obj);
	}
	//如果用for each迭代
	//结果和for each相同，new object输出的仍是引用地址
	for(Object data:a) {
		System.out.println(data);
	}
	/*
	//使用泛型遍历，这样写不可以只遍历出String，因为a中有别的类型，而遍历器作用是全部遍历数组
	//所以必须要给集合规定泛型
	Iterator<String>it1=a.iterator();
	while(it1.hasNext()) {
		String b=it1.next();
		System.out.println(b);
	}
	*/
	//新建一个String类的集合，并且使用钻石表达式
	//也可以不使用向上转型：向上转型：父左子右
	Collection<String>c=new ArrayList<>();
	Iterator<String>it1=a.iterator();
	while(it1.hasNext()) {
		String b=it1.next();
		System.out.println(b);

	}
	}
	//试一下自定义泛型
class MyIterator<E>{
	public E get() {
		return null;
	}
	}
}


	