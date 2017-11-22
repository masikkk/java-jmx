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
	
	public void printColor(String color1, String color2) {
		System.out.println("Car.printColor(String, String)被调用");
		System.out.println("color1: " + color1 + " color2: " + color2);
	}
}
