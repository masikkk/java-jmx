package com.masikkk.jmx.standard;

//命名规则：类名+MBean必须等于接口名
public interface HelloStandardMBean {
    public String getAuthor();
    public void setAuthor(String author);
    public void printHello();
}
