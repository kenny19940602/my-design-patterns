package behavioral;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 访问者模式
 */
public class MyVisitor {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        Element elementA = new ConcreteElementA();
        Element elementC = new ConcreteElementC();
        Element elementB = new ConcreteElementB();
        objectStructure.addElement(elementA);
        objectStructure.addElement(elementB);
        objectStructure.addElement(elementC);
        Visitor concreteVisitor = new ConcreteVisitor();
        objectStructure.accept(concreteVisitor);
    }
}
abstract class Visitor{
    public abstract void visit(ConcreteElementA elementA);
    public abstract void visit(ConcreteElementB elementB);
    public void visit(ConcreteElementC elementC){
        //元素ConcreteElementC操作代码
        System.out.println("Visitor : visit");
    }
}

class ConcreteVisitor extends Visitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        //元素ConcreteElementA操作代码
        System.out.println("ConcreteVisitor : visit elementA");

    }

    @Override
    public void visit(ConcreteElementB elementB) {
        //元素ConcreteElementB操作代码
        System.out.println("ConcreteVisitor : visit elementB");

    }
}
class ConcreteVisitorA extends Visitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        //元素ConcreteElementA操作代码
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        //元素ConcreteElementB操作代码
    }
}

interface Element{
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        //业务方法
    }
}
class ConcreteElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        //业务方法
    }
}
class ConcreteElementC implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        //业务方法
    }
}
class ObjectStructure{
    private ArrayList<Element> list = new ArrayList<>();//定义一个集合用于存储元素对象

    public void accept(Visitor visitor) {
        Iterator<Element> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);//遍历访问集合中的每一个元素
        }
    }

    public void addElement(Element element) {
        list.add(element);
    }

    public void removeElement(Element element) {
        list.remove(element);
    }
}
