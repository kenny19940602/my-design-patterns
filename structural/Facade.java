package structural;

/**
 * 外观模式
 */
public class Facade {
    public static void main(String[] args) {
        AbstractFacade facade = new FacadeA();//可以通过反射 动态实例化
        facade.Method();
    }
}

class SubSystemA {
    public void MethodA() {
        //业务实现代码
    }
}

class SubSystemB {
    public void MethodB() {
        //业务实现代码
    }
}

class SubSystemC {
    public void MethodC() {
        //业务实现代码
    }
}

abstract class AbstractFacade {
    public abstract void Method();
}

class FacadeA extends AbstractFacade {
    private SubSystemA obj1 = new SubSystemA();
    private SubSystemB obj2 = new SubSystemB();
    private SubSystemC obj3 = new SubSystemC();

    @Override
    public void Method() {
        obj1.MethodA();
        obj2.MethodB();
        obj3.MethodC();
    }
}

class FacadeB extends AbstractFacade {
    private SubSystemA obj1 = new SubSystemA();
    private SubSystemB obj2 = new SubSystemB();
    private SubSystemC obj3 = new SubSystemC();
    private SubSystemD obj4 = new SubSystemD();

    @Override
    public void Method() {
        obj1.MethodA();
        obj2.MethodB();
        obj3.MethodC();
        obj4.MethodD();

    }


}
class SubSystemD {
    public void MethodD() {
        //业务实现代码
    }
}
