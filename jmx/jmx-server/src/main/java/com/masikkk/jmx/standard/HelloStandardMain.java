package com.masikkk.jmx.standard;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class HelloStandardMain {
    public static void main(String[] args) throws Exception{
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        //将一个HelloStandard实例作为MBean对象注册到
        mBeanServer.registerMBean(new HelloStandard(), new ObjectName("MBeanTest:name=StandardMBean"));
        System.out.println("标准MBean已注册到本地！");
        Thread.sleep(60*60*1000);
    }
}
