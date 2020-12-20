package behavioral;

import java.util.ArrayList;

/**
 * 观察者模式  jdk 支持Observer观察者   Observable被观察者
 */
public class MyObserver {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        System.out.println("被观察者变化了");
        concreteSubject.notify1();
    }
}

abstract class Subject {

    //定义一个观察者集合用于存储所有观察者对象
    protected ArrayList<Observer> observers = new ArrayList();

    //注册方法，用于向观察者集合中增加一个观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //注销方法，用于在观察者集合中删除一个观察者
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    //声明抽象通知方法
    public abstract void notify1();

}

class ConcreteSubject extends Subject {
    //实现通知方法
    @Override
    public void notify1() {
        //遍历观察者集合，调用每个观察者的相应方法
        for (Observer obs : observers) {
            obs.update();
        }

    }
}

interface Observer {

    //声明相应方法
    void update();
}

class ConcreteObserver implements Observer {

    //实现相应方法
    @Override
    public void update() {
        //具体相应代码
        System.out.println("观察者响应了");

    }
}

