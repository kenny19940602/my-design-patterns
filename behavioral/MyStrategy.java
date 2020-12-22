package behavioral;

/**
 * 策略模式
 */
public class MyStrategy {
    public static void main(String[] args) {
        AbstractStrategy strategy = new ConcreteStrategyA();//可运行时指定类型2
        Context2 context = new Context2(strategy);
        context.algorithm();
    }
}
abstract class AbstractStrategy{
    abstract void algorithm();//声明抽象算法
}

class ConcreteStrategyA extends AbstractStrategy {

    //算法的具体实现
    @Override
    void algorithm() {
        //算法A
        System.out.println("A算法");
    }
}
class ConcreteStrategyB extends AbstractStrategy {

    //算法的具体实现
    @Override
    void algorithm() {
        //算法B
        System.out.println("B算法");

    }
}
class Context2{
    private AbstractStrategy strategy;//维持一个抽象策略类的引用

    public Context2(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    //调用策略类中的算法
    public void algorithm(){
        strategy.algorithm();
    }
}
