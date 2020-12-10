package creational;

/**
 * 单例模式(略)
 */
public class Singleton {
}
enum SingletonsHolder {

    PRESIDENT(new President());

    private Object holdedObject;

    private SingletonsHolder(Object o) {
        this.holdedObject = o;
    }

    public Object getHoldedObject() {
        return this.holdedObject;
    }

}

class President {
}