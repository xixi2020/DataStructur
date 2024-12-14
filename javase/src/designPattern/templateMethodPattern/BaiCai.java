package designPattern.templateMethodPattern;
//实现要炒白菜的步骤，重写子类必须实现的两个方法：放蔬菜和调料
public class BaiCai extends AbstractClass{
    @Override
    public void putVagtable() {
        System.out.println("放白菜了！");

    }

    @Override
    public void pourSauce() {
        System.out.println("白菜很甜，只需加盐");
    }
}
