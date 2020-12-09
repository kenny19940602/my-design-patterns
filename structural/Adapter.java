package structural;

/**
 * 适配器 ： 适配器模式(Adapter Pattern)：将一个接口转换成客户希望的另一个接口，使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。
 * 对象适配器 (常用)
 * 类适配器 (不常用)
 * 双向适配器 (不常用)
 * 缺省适配器 (常用)
 * <p>
 * <p>
 * 1. 主要优点
 * <p>
 * 无论是对象适配器模式还是类适配器模式都具有如下优点：
 * <p>
 * (1) 将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无须修改原有结构。
 * <p>
 * (2) 增加了类的透明性和复用性，将具体的业务实现过程封装在适配者类中，对于客户端类而言是透明的，而且提高了适配者的复用性，同一个适配者类可以在多个不同的系统中复用。
 * <p>
 * (3) 灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，也可以在不修改原有代码的基础上增加新的适配器类，完全符合“开闭原则”。
 * <p>
 * 具体来说，类适配器模式还有如下优点：
 * <p>
 * 由于适配器类是适配者类的子类，因此可以在适配器类中置换一些适配者的方法，使得适配器的灵活性更强。
 * <p>
 * 对象适配器模式还有如下优点：
 * <p>
 * (1) 一个对象适配器可以把多个不同的适配者适配到同一个目标；
 * <p>
 * (2) 可以适配一个适配者的子类，由于适配器和适配者之间是关联关系，根据“里氏代换原则”，适配者的子类也可通过该适配器进行适配。
 * <p>
 * <p>
 * <p>
 * 2. 主要缺点
 * <p>
 * 类适配器模式的缺点如下：
 * <p>
 * (1) 对于Java、C#等不支持多重类继承的语言，一次最多只能适配一个适配者类，不能同时适配多个适配者；
 * <p>
 * (2) 适配者类不能为最终类，如在Java中不能为final类，C#中不能为sealed类；
 * <p>
 * (3) 在Java、C#等语言中，类适配器模式中的目标抽象类只能为接口，不能为类，其使用有一定的局限性。
 * <p>
 * 对象适配器模式的缺点如下：
 * <p>
 * 与类适配器模式相比，要在适配器中置换适配者类的某些方法比较麻烦。如果一定要置换掉适配者类的一个或多个方法，可以先做一个适配者类的子类，将适配者类的方法置换掉，然后再把适配者类的子类当做真正的适配者进行适配，实现过程较为复杂。
 * <p>
 * <p>
 * <p>
 * 3. 适用场景
 * <p>
 * 在以下情况下可以考虑使用适配器模式：
 * <p>
 * (1) 系统需要使用一些现有的类，而这些类的接口（如方法名）不符合系统的需要，甚至没有这些类的源代码。
 * <p>
 * (2) 想创建一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作。
 */
public class Adapter {
    public static void main(String args[]) {
        ScoreOperation operation;  //针对抽象目标接口编程
//        operation = (ScoreOperation)XMLUtil.getBean(); //读取配置文件，反射生成对象
        operation = new OperationAdapter();
        int scores[] = {84, 76, 50, 69, 90, 91, 88, 96}; //定义成绩数组
        int result[];
        int score;

        System.out.println("成绩排序结果：");
        result = operation.sort(scores);

        //遍历输出成绩
        for (int i : scores) {
            System.out.print(i + ",");
        }
        System.out.println();

        System.out.println("查找成绩90：");
        score = operation.search(result, 90);
        if (score != -1) {
            System.out.println("找到成绩90。");
        } else {
            System.out.println("没有找到成绩90。");
        }

        System.out.println("查找成绩92：");
        score = operation.search(result, 92);
        if (score != -1) {
            System.out.println("找到成绩92。");
        } else {
            System.out.println("没有找到成绩92。");
        }
    }

}

//抽象成绩操作类：目标接口
interface ScoreOperation {
    public int[] sort(int array[]); //成绩排序

    public int search(int array[], int key); //成绩查找
}

//快速排序类：适配者
class QuickSort {
    public int[] quickSort(int array[]) {
        sort(array, 0, array.length - 1);
        return array;
    }

    public void sort(int array[], int p, int r) {
        int q = 0;
        if (p < r) {
            q = partition(array, p, r);
            sort(array, p, q - 1);
            sort(array, q + 1, r);
        }
    }

    public int partition(int[] a, int p, int r) {
        int x = a[r];
        int j = p - 1;
        for (int i = p; i <= r - 1; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, j, i);
            }
        }
        swap(a, j + 1, r);
        return j + 1;
    }

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

//二分查找类：适配者
class BinarySearch {
    public int binarySearch(int array[], int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return 1; //找到元素返回1
            }
        }
        return -1;  //未找到元素返回-1
    }
}

//操作适配器：适配器

/**
 * 对象适配器
 */
class OperationAdapter implements ScoreOperation {
    private QuickSort sortObj; //定义适配者QuickSort对象
    private BinarySearch searchObj; //定义适配者BinarySearch对象

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    public int[] sort(int array[]) {
        return sortObj.quickSort(array); //调用适配者类QuickSort的排序方法
    }

    public int search(int array[], int key) {
        return searchObj.binarySearch(array, key); //调用适配者类BinarySearch的查找方法
    }
}

/**
 * 类适配器 适配器类实现了抽象目标类接口Target，并继承了适配者类，在适配器类的request()方法中调用所继承的适配者类的specificRequest()方法，实现了适配。
 * <p>
 * 双向适配器 适配器中同时包含对目标类和适配者类的引用，适配者可以通过它调用目标类中的方法，目标类也可以通过它调用适配者类中的方法，那么该适配器就是一个双向适配器
 * <p>
 * 在实际开发中，我们很少使用双向适配器。
 */
//class Adapter extends Adaptee implements Target {
//    public void request() {
//        specificRequest();
//    }
//}

/**
 * 双向适配器 适配器中同时包含对目标类和适配者类的引用，适配者可以通过它调用目标类中的方法，目标类也可以通过它调用适配者类中的方法，那么该适配器就是一个双向适配器
 *
 * 在实际开发中，我们很少使用双向适配器。
 */
//class Adapter implements Target,Adaptee {
//    //同时维持对抽象目标类和适配者的引用
//    private Target target;
//    private Adaptee adaptee;
//
//    public Adapter(Target target) {
//        this.target = target;
//    }
//
//    public Adapter(Adaptee adaptee) {
//        this.adaptee = adaptee;
//    }
//
//    public void request() {
//        adaptee.specificRequest();
//    }
//
//    public void specificRequest() {
//        target.request();
//    }
//}

/**
 * 适配者接口 它是一个接口，通常在该接口中声明了大量的方法。
 */
interface ServiceInterface {
    void serviceMethod1();

    void serviceMethod2();

    void serviceMethod3();
}

/**
 * 缺省适配器类 它是缺省适配器模式的核心类，使用空方法的形式实现了在ServiceInterface接口中声明的方法。通常将它定义为抽象类，因为对它进行实例化没有任何意义
 */
abstract class AbstractServiceClass implements ServiceInterface {

    @Override
    public void serviceMethod1() {

    }

    @Override
    public void serviceMethod2() {

    }

    @Override
    public void serviceMethod3() {

    }
}

/**
 * 具体业务类 它是缺省适配器类的子类，在没有引入适配器之前，它需要实现适配者接口，因此需要实现在适配者接口中定义的所有方法，而对于一些无须使用的方法也不得不提供空实现。在有了缺省适配器之后，可以直接继承该适配器类，根据需要有选择性地覆盖在适配器类中定义的方法
 */
class ConcreteServiceClass extends AbstractServiceClass {

    @Override
    public void serviceMethod3() {
        System.out.println("重写serviceMethod3");
    }
}
