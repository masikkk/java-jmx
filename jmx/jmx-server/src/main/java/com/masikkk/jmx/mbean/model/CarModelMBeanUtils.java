package com.masikkk.jmx.mbean.model;

import javax.management.MBeanException;
import javax.management.MBeanOperationInfo;
import javax.management.RuntimeOperationsException;
import javax.management.modelmbean.ModelMBean;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class CarModelMBeanUtils {

	public static ModelMBean createCarModelMBean() {
		ModelMBean modelMBean = null;
		try {
			modelMBean = new RequiredModelMBean(); //创建模型MBean
			modelMBean.setManagedResource(new Car(), "ObjectReference"); //设置模型MBean管理的对象实例
			modelMBean.setModelMBeanInfo(createModelMBeanInfo()); //设置ModelMBeanInfo描述信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelMBean;
	}
	
	private static ModelMBeanInfo createModelMBeanInfo() {
		ModelMBeanInfo modelMBeanInfo = null;
		ModelMBeanAttributeInfo[] attributeInfos = new ModelMBeanAttributeInfo[1]; //属性
		ModelMBeanOperationInfo[] operationInfos = new ModelMBeanOperationInfo[4]; //方法
		try {
			attributeInfos[0] = new ModelMBeanAttributeInfo("Color", "java.lang.String", 
					"Car's color", true, true, false, null);
			operationInfos[0] = new ModelMBeanOperationInfo("getColor", "getColor Method", 
					null, "java.lang.String", MBeanOperationInfo.INFO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return modelMBeanInfo;
	}
	
}
