package com.masikkk.jmx.mbean.model;

import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.modelmbean.ModelMBean;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;

public class CarModelMBeanUtils {

	public static ModelMBean createCarModelMBean() {
		ModelMBean modelMBean = null;
		try {
			modelMBean = new RequiredModelMBean(); //创建模型MBean
			modelMBean.setManagedResource(new Car(), "ObjectReference"); //设置模型MBean管理的对象实例
			ModelMBeanInfo modelMBeanInfo = createModelMBeanInfo();
			modelMBean.setModelMBeanInfo(modelMBeanInfo); //设置ModelMBeanInfo描述信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelMBean;
	}
	
	//创建Car类的模型MBean描述信息
	private static ModelMBeanInfo createModelMBeanInfo() {
		ModelMBeanInfo modelMBeanInfo = null;
		ModelMBeanAttributeInfo[] attributeInfos = new ModelMBeanAttributeInfo[1]; //属性数组
		ModelMBeanOperationInfo[] operationInfos = new ModelMBeanOperationInfo[4]; //方法数组
		try {
			//属性color
			attributeInfos[0] = new ModelMBeanAttributeInfo(
					"color",  //属性名称
					"java.lang.String", //属性的类型名称或类名称
					"Car's color", //属性的可读描述
					true, //isReadable 
					true, //isWritable 
					false, //isIs，属性是否有"is"方法 
					null //Descriptor类型的描述符，如果为null则自动创建默认描述符
					);
			
			//方法getColor()
			operationInfos[0] = new ModelMBeanOperationInfo(
					"getColor", //方法名称
					"getColor Method", //操作的可读描述
					null, //描述方法参数的MBeanParameterInfo对象数组
					"java.lang.String", //方法返回值的类型
					MBeanOperationInfo.INFO, //方法的影响，读取操作
					null //Descriptor类型的描述符，如果为null则自动创建默认描述符
					);
		
			//方法setColor()的参数
			MBeanParameterInfo[] setColorParams = new MBeanParameterInfo[]{
					new MBeanParameterInfo("collor", "java.lang.String", "new Color value", null)
					};
			
			//方法setColor()
			operationInfos[1] = new ModelMBeanOperationInfo(
					"setColor", 
					"setColor Method", 
					setColorParams, 
					"void", 
					MBeanOperationInfo.ACTION, //方法的影响，写入操作
					null);		
			
			//方法printColor()
			operationInfos[2] = new ModelMBeanOperationInfo(
					"printColor", 
					"printColor Method", 
					null, 
					"void", 
					MBeanOperationInfo.INFO, //方法的影响，读取操作
					null);
			
			//方法printColor(String,String)的参数
			MBeanParameterInfo[] printColorParams = new MBeanParameterInfo[]{
					new MBeanParameterInfo("collor1", "java.lang.String", "color1 value", null),
					new MBeanParameterInfo("collor2", "java.lang.String", "color2 value", null)
					};			
			
			//方法printColor(String,String)
			operationInfos[3] = new ModelMBeanOperationInfo(
					"printColor(String,String)", 
					"printColor(String,String) Method", 
					printColorParams, 
					"void", 
					MBeanOperationInfo.ACTION, //方法的影响，写入操作
					null);			
			
			//构造ModelMBeanInfo结构
			modelMBeanInfo = new ModelMBeanInfoSupport(
					"com.masikkk.jmx.mbean.model.Car", //MBean 的类名称
					"Car类的模型MBean描述", //ModelMBean 的可读描述
					attributeInfos, //描述属性的ModelMBeanAttributeInfo对象数组
					null, //描述构造函数的ModelMBeanConstructorInfo 对象数组
					operationInfos, //描述方法的ModelMBeanOperationInfo 对象数组
					null, //描述通知的ModelMBeanNotificationInfo 对象数组
					null //Descriptor类型的描述符，如果为null则自动创建默认描述符
					);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return modelMBeanInfo;
	}
}
