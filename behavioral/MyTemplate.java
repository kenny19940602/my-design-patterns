package behavioral;

/**
 * 模板方法模式
 */
public class MyTemplate {
    public static void main(String[] args) {
        AbstractTemplate concreteClass = new ConcreteClass();
        concreteClass.templateMethod();

    }
}

abstract class AbstractTemplate {


    //模板方法
    public void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        if(primitiveOperation3()){
            System.out.println("子类钩子方法  控制模板方法 ");
        }
    }

    //基本方法—具体方法
    public void primitiveOperation1() {
        //实现代码
    }

    //基本方法—抽象方法
    public abstract void primitiveOperation2();

    //基本方法—钩子方法
    public Boolean primitiveOperation3() {
        System.out.println("默认钩子方法 返回 true");
        return true;
    }
}
class ConcreteClass extends AbstractTemplate{

    @Override
    public void primitiveOperation2() {
        System.out.println("子类实现模板方法");
    }

    @Override
    public Boolean primitiveOperation3() {
        System.out.println("子类重写父类钩子方法，以实现控制模板方法");
        return false;
    }
}



