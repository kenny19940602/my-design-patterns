package com.spaceon.gms.workdistribution.structural;

/**
 * 装饰模式 使用装饰模式之后将大大减少了子类的个数，让系统扩展起来更加方便，而且更容易维护，是取代继承复用的有效方式之一。
 * 透明装饰模式 可以多次装饰
 * 半透明装饰模式 不可以多次装饰
 */
public class Decorator {
    public static void main(String args[]) {
//        Component component, componentSB;  //使用抽象构件定义
//        component = new Window(); //定义具体构件
//        componentSB = new ScrollBarDecorator(component); //定义装饰后的构件
//        componentSB.display();

//        /**
//         * 半透明演示
//         */
//        Component component, componentSB;  //使用抽象构件定义
//        component = new Window(); //定义具体构件
//        ScrollBarDecorator scrollBarDecorator = new ScrollBarDecorator(component); //定义装饰后的构件  //重点
//        scrollBarDecorator.display();
//        scrollBarDecorator.setColor();//重点

        /**
         * 透明模式  多次装饰
         */
        Component  component,componentSB,componentBB; //全部使用抽象构件定义
        component = new Window();
        componentSB = new  ScrollBarDecorator(component);
        componentBB = new  BlackBorderDecorator(componentSB); //将装饰了一次之后的对象继续注入到另一个装饰类中，进行第二次装饰
        componentBB.display();
    }
}
//抽象界面构件类：抽象构件类，为了突出与模式相关的核心代码，对原有控件代码进行了大量的简化

abstract class Component {
    public abstract void display();
}


//窗体类：具体构件类

class Window extends Component {
    @Override
    public void display() {
        System.out.println("显示窗体！");
    }

}


//文本框类：具体构件类

class TextBox extends Component {

    @Override
    public void display() {
        System.out.println("显示文本框！");
    }

}


//列表框类：具体构件类

class ListBox extends Component {

    @Override
    public void display() {
        System.out.println("显示列表框！");
    }

}


//构件装饰类：抽象装饰类

class ComponentDecorator extends Component {

    private Component component;  //维持对抽象构件类型对象的引用


    public ComponentDecorator(Component component)  //注入抽象构件类型的对象
    {
        this.component = component;
    }


    @Override
    public void display() {
        component.display();
    }

}


//滚动条装饰类：具体装饰类

class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }


    @Override
    public void display() {
        this.setScrollBar();
        super.display();

    }


    public void setScrollBar() {
        System.out.println("为构件增加滚动条！");
    }

    public void setColor() {
        System.out.println("半透明演示");

    }

}


//黑色边框装饰类：具体装饰类

class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }


    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }


    public void setBlackBorder() {
        System.out.println("为构件增加黑色边框！");
    }

}