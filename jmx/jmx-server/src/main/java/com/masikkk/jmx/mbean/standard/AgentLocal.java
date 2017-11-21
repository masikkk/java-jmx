package com.masikkk.jmx.mbean.standard;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class AgentLocal {
    public static void main(String[] args) throws Exception{
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        //将一个Hello实例作为MBean对象注册到本地MBean服务器中，并指定MBean的对象名
        mBeanServer.registerMBean(new Hello(), new ObjectName("MBeanDomain:name=StandardMBeanLocal"));
        System.out.println("标准MBean已注册到本地！请使用JConsole连接本地进程测试！");
        Thread.sleep(60*60*1000);
    }
}
