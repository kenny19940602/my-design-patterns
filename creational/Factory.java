package com.spaceon.gms.workdistribution.creational;

/**
 * 工厂模式
 */
class Factory {

    public static void main(String[] args) {
        BaseFactory factory = new FileFactory();//动态读取配置 ，反射创建实例 BaseFactory factory = (BaseFactory)XMLUtil.getBean();
        factory.writeLog();
    }
}

//日志记录器接口：抽象产品
interface Logger {
    public void writeLog();
}

//数据库日志记录器：具体产品
class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录。");
    }
}

//文件日志记录器：具体产品
class FileLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("文件日志记录。");
    }
}

class DatabaseFactory implements BaseFactory{

    /**
     * 隐藏了工厂方法
     */
    //在工厂类中直接调用日志记录器类的业务方法writeLog()
    @Override
    public void writeLog() {
        Logger logger = new DatabaseLogger();
        logger.writeLog();
    }
    @Override
    public void writeLog(String args) {
        Logger logger = new DatabaseLogger();
        logger.writeLog();
    }
    @Override
    public void writeLog(Object obj) {
        Logger logger = new DatabaseLogger();
        logger.writeLog();
    }

}
class FileFactory implements BaseFactory{
    //在工厂类中直接调用日志记录器类的业务方法writeLog()
    @Override
    public void writeLog() {
        Logger logger = new FileLogger();
        logger.writeLog();
    }
    @Override
    public void writeLog(String args) {
        Logger logger = new FileLogger();
        logger.writeLog();
    }
    @Override
    public void writeLog(Object obj) {
        Logger logger = new FileLogger();
        logger.writeLog();
    }

}
interface BaseFactory {
//    Logger getLogger(); 一般是工厂创建对象，调用方法

    /**
     * 这个把 创建对象，调用方法合并了  也就是隐藏了工厂创建对象，使用者感受不到创建对象的过程
     */
    void writeLog() ;
    void writeLog(String args) ;
    void writeLog(Object obj) ;
}






