package com.masikkk.jmx.agent;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.masikkk.jmx.mbean.standard.HelloStandard;

public class StandardAgentRMI {
	public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        //将一个HelloStandard实例作为MBean对象注册到本地MBean服务器中，并指定MBean的对象名
        mBeanServer.registerMBean(new HelloStandard(), new ObjectName("MBeanTest:name=StandardMBean"));

        try {
        	//创建远程对象注册表Registry的实例，被创建的Registry将在指定的端口（默认1099）上侦听到来的请求
            LocateRegistry.createRegistry(8899);
            
            String ip_port = "localhost" + ":" + "8899";
            String jmxAddress = "service:jmx:rmi://" + ip_port + "/jndi/rmi://" + ip_port + "/jmxrmi";
            //String jmxAddress = "service:jmx:rmi:///jndi/rmi://localhost:8899/jmxrmi";
            JMXServiceURL url = new JMXServiceURL(jmxAddress); //JMX连接器服务器地址
            
            //创建位于给定地址的连接器服务器，并指定该连接器服务器连接到的MBean服务器
            JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mBeanServer);
            
            jcs.start(); //激活连接器服务器，即开始侦听客户端连接。
            
            System.out.println("JMX连接服务器已启动！请使用JConsole连接远程进程localhost:8899进行测试！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
