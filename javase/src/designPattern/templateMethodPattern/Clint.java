package designPattern.templateMethodPattern;
//这里是我们的厨房
public class Clint {
    public static void main(String[] args) {
        Baocai baocai = new Baocai();
        baocai.cookProcess();
        BaiCai baiCai = new BaiCai();
        baiCai.cookProcess();
    }
}
