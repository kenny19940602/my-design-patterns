package com.spaceon.gms.workdistribution.creational;

import java.util.Objects;

/**
 * 简单工厂
 */
abstract class Product {
    public abstract String getClassName() ;
    public static Product getProductFactory(String type){
        /**
         * 只能在此处扩展，违背开闭原则
         */
        if (Objects.equals("A", type)) {
            return new ConcreteProductA();
        } else if (Objects.equals("B", type)) {
            return new ConcreteProductB();
        }
        return null;
    };

    public static void main(String[] args) {
        /**
         * A 可以动态配置xml读取
         */
        Product a = getProductFactory("A");
        System.out.println(a.getClassName());
    }
}
class ConcreteProductA extends Product {
    @Override
    public String getClassName() {
        return "A";
    }
}
class ConcreteProductB extends Product {
    @Override
    public String getClassName() {
        return "B";
    }
}
