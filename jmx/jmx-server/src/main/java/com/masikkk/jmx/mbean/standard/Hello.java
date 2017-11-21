package com.masikkk.jmx.mbean.standard;

//标准MBean实现类，命名规则：类名+MBean必须等于接口名
public class Hello implements HelloMBean{
    String author;
    @Override
    public void printHello() {
    	System.out.println("Hello.printHello()被调用");
        System.out.println("你好，"+author);
    }

    @Override
    public String getAuthor() {
    	System.out.println("Hello.getAuthor()被调用");
        return author;
    }

    @Override
    public void setAuthor(String author) {
    	System.out.println("Hello.setAuthor()被调用");
        this.author = author;
    }
}
