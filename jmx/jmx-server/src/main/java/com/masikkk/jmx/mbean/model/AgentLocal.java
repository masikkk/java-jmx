package com.masikkk.jmx.mbean.model;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBean;

public class AgentLocal {
	public static void main(String[] args) throws Exception {
    	//获取平台MBeanServer
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        //通过工具类CarModelMBeanUtils创建Car类的模型MBean
        ModelMBean modelMBean = CarModelMBeanUtils.createCarModelMBean();
        
        //将Car类的模型MBean注册到本地MBean服务器中，并指定MBean的对象名
        mBeanServer.registerMBean(modelMBean, new ObjectName("MBeanDomain:name=ModelMBeanLocal"));

        System.out.println("模型MBean已注册到本地！请使用JConsole连接本地进程测试！");
        Thread.sleep(60*60*1000);        
	}

}
