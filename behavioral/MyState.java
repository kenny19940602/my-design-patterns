package behavioral;

/**
 * 状态模式 状态改变则行为不同
 */
public class MyState {
    public static void main(String[] args) {
        Context1 context = new Context1();
        context.setState(new ConcreteState(context));
        context.setValue(1);
        context.request();
        context.setValue(2);
        context.request();
        context.request();

    }
}
abstract class State{
    protected Context1 context;
    //声明抽象业务方法，不同的具体状态类可以不同的实现
    public abstract void handle();
}

class ConcreteState extends State {
    public ConcreteState( Context1 context) {
        this.context = context;
    }

    @Override
    public void handle() {
        //方法具体实现代码
        System.out.println("ConcreteState + +++++++++");
        changeState(context);

    }

    public void changeState(Context1 ctx) {
        //根据环境对象中的属性值进行状态转换
        if (ctx.getValue() == 1) {
            ctx.setState(new ConcreteStateB(ctx));
        } else if (ctx.getValue() == 2) {
            ctx.setState(new ConcreteStateC(ctx));
        }
    }
}
class ConcreteStateB extends State {
    public ConcreteStateB( Context1 context) {
        this.context = context;
    }

    @Override
    public void handle() {
        //方法具体实现代码
        System.out.println("ConcreteStateB + +++++++++");
        changeState(context);


    }

    public void changeState(Context1 ctx) {
        //根据环境对象中的属性值进行状态转换
        if (ctx.getValue() == 1) {
            ctx.setState(new ConcreteStateB(ctx));
        } else if (ctx.getValue() == 2) {
            ctx.setState(new ConcreteStateC(ctx));
        }
    }
}
class ConcreteStateC extends State {
    public ConcreteStateC( Context1 context) {
        this.context = context;
    }

    @Override
    public void handle() {
        //方法具体实现代码
        System.out.println("ConcreteStateC + +++++++++");
        changeState(context);
    }

    public void changeState(Context1 ctx) {
        //根据环境对象中的属性值进行状态转换
        if (ctx.getValue() == 1) {
            ctx.setState(new ConcreteStateB(ctx));
        } else if (ctx.getValue() == 2) {
            ctx.setState(new ConcreteStateC(ctx));
        }
    }
}
class Context1{
    private State state;//维持一个对象抽象状态对象的引用
    private int value; //其他属性值，该值的变化可能会导致对象状态发生改变

    //设置状态对象
    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        //其他代码
        state.handle();//调用状太对象的业务方法
        //其他代码
    }

    public State getState() {
        return state;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}