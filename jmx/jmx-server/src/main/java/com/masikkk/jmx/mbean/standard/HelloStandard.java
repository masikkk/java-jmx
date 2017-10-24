package com.masikkk.jmx.mbean.standard;

//标准MBean实现类，命名规则：类名+MBean必须等于接口名
public class HelloStandard implements HelloStandardMBean{
    String author;
    @Override
    public void printHello() {
    	System.out.println("HelloStandard.printHello()被调用");
        System.out.println("你好，"+author);
    }

    @Override
    public String getAuthor() {
    	System.out.println("HelloStandard.getAuthor()被调用");
        return author;
    }

    @Override
    public void setAuthor(String author) {
    	System.out.println("HelloStandard.setAuthor()被调用");
        this.author = author;
    }
}
