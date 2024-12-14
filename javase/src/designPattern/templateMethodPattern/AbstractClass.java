package designPattern.templateMethodPattern;

/**
 * 模板方法设计模式：炒菜为例
 * 模板方法设计模式：在一个抽象类中定义一个操作中的算法骨架，将一些具体实现延迟到子类中去实现
 * 抽象类中由模板方法（算法骨架）以及若干个基本方法组成
 */
public abstract class AbstractClass {
    //模板方法:规定做菜算法的骨架。
    public final void cookProcess(){
        //倒油
        this.pourOil();
        //热油
        this.hotOil();
        //放入菜
        this.putVagtable();
        //调料
        this.pourSauce();
        //翻炒
        this.fry();
    }

    //具体倒油的实现
    private void pourOil() {
        System.out.println("倒油");
    }
    //热油
    private void hotOil() {
        System.out.println("热油");
    }
    //放入蔬菜方法由子类来规定，这里设为抽象类
    public abstract void putVagtable();
    //放调料也由子类实现
    public abstract void pourSauce();
    //翻炒
    private void fry() {
        System.out.println("let us fry!!");
    }

}