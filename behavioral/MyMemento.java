package behavioral;

/**
 * 备忘录模式
 */
public class MyMemento {

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("start");
        Memento memento = new Memento(originator);
        System.out.println(originator.getState());
        caretaker.setMemento(memento);
        originator.setState("running");
        System.out.println(originator.getState());
        caretaker.setMemento(memento);
        originator.setState("stop");
        System.out.println(originator.getState());
        System.out.println("开始回滚++++++++++++++++++++++++++++++++");
        originator.restoreMemento(memento);
        System.out.println(originator.getState());
    }

}
class Originator{
    private String state;

    public Originator() {
    }

    //创建一个备忘录对象
    public Memento createMemento(){
        return new Memento(this);
    }

    //创建备忘录对象恢复原发器状态
    public void restoreMemento(Memento memento) {
        this.state = memento.getState();
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
//备忘录类，默认可见性，包内可见
class Memento{
    private String state;

    public Memento(Originator o) {
        this.state = o.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Caretaker{
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}