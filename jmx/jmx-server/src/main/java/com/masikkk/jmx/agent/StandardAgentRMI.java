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
            LocateRegistry.createRegistry(8899);
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:8899/jmxrmi");
            JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mBeanServer);
            jcs.start();
            System.out.println("JMX连接服务器已启动！请使用JConsole连接远程进程localhost:8899进行测试！");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
