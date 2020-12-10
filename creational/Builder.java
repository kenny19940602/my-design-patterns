package com.spaceon.gms.workdistribution.creational;

/**
 * 建造者模式  一般构造复杂对象使用
 */
public class Builder {

    public static void main(String[] args) {

        ActorBuilder ab; //针对抽象建造者编程
//        ab =  (ActorBuilder)XMLUtil.getBean(); //反射生成具体建造者对象
        ab = new AngelBuilder(); //反射生成具体建造者对象
        ActorController ac = new  ActorController();
        Actor actor;
        actor = ac.construct(ab); //通过指挥者创建完整的建造者对象
        String  type = actor.getType();
        System.out.println(type  + "的外观：");
        System.out.println("性别：" + actor.getSex());
        System.out.println("面容：" + actor.getFace());
        System.out.println("服装：" + actor.getCostume());
        System.out.println("发型：" + actor.getHairstyle());
    }
}
//Actor角色类：复杂产品，考虑到代码的可读性，只列出部分成员属性，且成员属性的类型均为String，真实情况下，有些成员属性的类型需自定义

class Actor {

    private String type; //角色类型
    private String sex; //性别
    private String face; //脸型
    private String costume; //服装
    private String hairstyle; //发型

    public void setType(String type) {
        this.type = type;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    public void setHairstyle(String hairstyle) {
        this.hairstyle = hairstyle;
    }

    public String getType() {
        return (this.type);
    }

    public String getSex() {
        return (this.sex);
    }

    public String getFace() {
        return (this.face);
    }

    public String getCostume() {
        return (this.costume);
    }

    public String getHairstyle() {
        return (this.hairstyle);
    }

}


//角色建造器：抽象建造者

abstract class ActorBuilder {

    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();


    //工厂方法，返回一个完整的游戏角色对象
    public Actor createActor() {
        return actor;
    }

}


//英雄角色建造器：具体建造者

class HeroBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("英俊");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("盔甲");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("飘逸");
    }

}

//天使角色建造器：具体建造者
class AngelBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType("天使");
    }

    @Override
    public void buildSex() {
        actor.setSex("女");
    }

    @Override
    public void buildFace() {
        actor.setFace("漂亮");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("白裙");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("披肩长发");
    }

}


//恶魔角色建造器：具体建造者
class DevilBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        actor.setSex("妖");
    }

    @Override
    public void buildFace() {
        actor.setFace("丑陋");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("黑衣");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("光头");
    }

}
//游戏角色创建控制器：指挥者
class ActorController {
    //逐步构建复杂产品对象
    public Actor construct(ActorBuilder ab) {
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        actor=ab.createActor();
        return actor;
    }

}