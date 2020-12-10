package structural;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理模式
 */
public class Proxy {
    public static void main(String[] args) {
        A target = new Target();
//        ClassLoader classLoader = target.getClass().getClassLoader();
//        Class<?>[] interfaces = target.getClass().getInterfaces();
//        Handler handler = new Handler(target);
        A proxyInstance = (A) java.lang.reflect.Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(), new Handler(target));
        proxyInstance.method();
    }
}

interface A{
    void method();
}

class Target implements A{

    @Override
    public void method() {
        System.out.println("do some thing");
    }
}

class Handler implements InvocationHandler {

    private Object a;

    public Handler(Object a) {
        this.a = a;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Start Proxy");
        method.invoke(a, args);
        System.out.println("end Proxy");
        return null;
    }
}