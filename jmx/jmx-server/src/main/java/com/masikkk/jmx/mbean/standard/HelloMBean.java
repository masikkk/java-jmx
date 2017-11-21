package com.masikkk.jmx.mbean.standard;

//标准MBean接口，命名规则：类名+MBean必须等于接口名
public interface HelloMBean {
    public String getAuthor();
    public void setAuthor(String author);
    public void printHello();
}
