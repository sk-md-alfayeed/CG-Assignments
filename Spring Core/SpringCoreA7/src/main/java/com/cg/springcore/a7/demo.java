package com.cg.springcore.a7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class demo {
	@Value("#{11+22}")
	private int x;
	@Value("#{2+5+74+8}")
	private int y;
	
	@Value("#{T(java.lang.Math).sqrt(81)}")
	private double z;
	@Value("#{new java.lang.String('Alpha')}")
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	@Override
	public String toString() {
		return "demo [x=" + x + ", y=" + y + ", z=" + z + ", name=" + name + "]";
	}
	
}
