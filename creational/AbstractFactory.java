package creational;

/**
 * 抽象工厂，扩展产品族容易(符合开闭原则) 扩展产品等级难(不符合开闭原则)
 */
public class AbstractFactory {
    public static void main(String[] args) {
        SkinFactory factory;
        Button bt;
        TextField tf;
        ComboBox cb;
//        factory = (SkinFactory)XMLUtil.getBean();//动态配置
        factory = new SpringSkinFactory();
        bt = factory.createButton();
        tf = factory.createTextField();
        cb = factory.createComboBox();
        bt.display();
        tf.display();
        cb.display();


    }
}

interface Button {
    public void display();
}

//Spring按钮类：具体产品
class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("显示浅绿色按钮。");
    }
}

//Summer按钮类：具体产品
class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("显示浅蓝色按钮。");
    }
}

//文本框接口：抽象产品
interface TextField {
    public void display();
}

//Spring文本框类：具体产品
class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示绿色边框文本框。");
    }
}

//Summer文本框类：具体产品
class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示蓝色边框文本框。");
    }
}

//组合框接口：抽象产品
interface ComboBox {
    public void display();
}

//Spring组合框类：具体产品
class SpringComboBox implements ComboBox {
    @Override
    public void display() {
        System.out.println("显示绿色边框组合框。");
    }
}

//Summer组合框类：具体产品
class SummerComboBox implements ComboBox {
    @Override
    public void display() {
        System.out.println("显示蓝色边框组合框。");
    }
}

//界面皮肤工厂接口：抽象工厂
interface SkinFactory {
    public Button createButton();
    public TextField createTextField();
    public ComboBox createComboBox();
}

//Spring皮肤工厂：具体工厂
class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }
    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }
    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}

//Summer皮肤工厂：具体工厂
class SummerSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SummerButton();
    }
    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }
    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
