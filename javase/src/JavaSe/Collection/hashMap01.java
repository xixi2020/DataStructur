package JavaSe.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
//Map集合的几个常见用法和遍历
//key值不可重复底层会调用equals方法来比较key值，自定义类型要重写HashCode和equals方法
public class hashMap01 {
	//创建集合
	public static void main(String[] args){
		Map<Integer,String> map=new HashMap<>();
		map.put(1,"zhangsan");
		map.put(2,"lisi");
		map.put(3,"wangwu");
		map.put(3,"zhangsan");
		//读取集合的元素个数
		System.out.println(map.size());
		//遍历集合
	    //把key提出来遍历value，hashmap的key为一个set集合
	    Set<Integer>keys=map.keySet();
	    Iterator<Integer> it=keys.iterator();
	    while(it.hasNext()) {
	    	Integer key=it.next();
	    	String value=map.get(key);
	    	System.out.println("key："+key+"value:  "+value);
	    }
	    //第二种遍历for each
	    //这里的keys是个set数组，key才是key的值
	    for(Integer key:keys) {
	    	System.out.println("key:  "+key+"value  "+map.get(key));
	    }
	    //第三种遍历方式：使用map的entry方法，map.entry,此时map.entry为一静态内部类
	    //是把map集合变成set集合
	    //Map<Map.Entry<Integer,String>> map=new HashMap();
	    Set<Entry<Integer,String>> set=map.entrySet();
	    //在这里遍历依然有两个值 key和vaule
	    //这里调用的是Map.entry中的构造器
	    //Iterator<Map.Entry<Integer,String>> it1=set.iterator();
	    //这里无法使用
	    //如果这里使用for each循环的话，必须要声明的类型
	    for(Entry<Integer, String> key:set) {
	    	System.out.println(key);
	    }
	    //用迭代器,迭代器中有getKey和getvalue方法
	    Iterator<Entry<Integer,String>> it1=set.iterator();
	    while(it1.hasNext()) {
	    	Entry<Integer,String>Node=it1.next();
	    	Integer key=Node.getKey();
	    	String value=Node.getValue();
	    	System.out.println(key+"="+value);
	    }
	}
	
	
		
	}
	

