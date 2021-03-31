package com.cg.springcore.a6;

public class HollywoodMovies {
	private String name;
	private String ProductionHouse;
	private int year;
	public HollywoodMovies(String name, String productionHouse, int year) {
		super();
		this.name = name;
		ProductionHouse = productionHouse;
		this.year = year;
	}
	public HollywoodMovies() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductionHouse() {
		return ProductionHouse;
	}
	public void setProductionHouse(String productionHouse) {
		ProductionHouse = productionHouse;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "HollywoodMovies [name=" + name + ", ProductionHouse=" + ProductionHouse + ", year=" + year + "]";
	}
	
}
