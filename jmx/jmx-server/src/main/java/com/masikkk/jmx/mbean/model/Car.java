package com.masikkk.jmx.mbean.model;

public class Car{
	private String color;

	public String getColor() {
		System.out.println("Car.getColor()被调用");
		return color;
	}

	public void setColor(String color) {
		System.out.println("Car.setColor()被调用");
		this.color = color;
	}
	
	public void printColor() {
		System.out.println("Car.printColor()被调用");
		System.out.println(color);
	}
	
	public void printColor(String otherColor) {
		System.out.println("Car.printColor(String)被调用");
		System.out.println(otherColor);
	}
}
