package com.cg.springcore.a6;

import org.springframework.beans.factory.annotation.Value;

public class BollywoodMovies {
	private String name;
	private String ProductionHouse;
	private int year;

	@Override
	public String toString() {
		return "BollywoodMovies [name=" + name + ", ProductionHouse=" + ProductionHouse + ", year=" + year + "]";
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

	@Value("xyz House")
	public void setProductionHouse(String productionHouse) {
		ProductionHouse = productionHouse;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BollywoodMovies() {
		super();
	}

	public BollywoodMovies(String name, String productionHouse, int year) {
		super();
		this.name = name;
		ProductionHouse = productionHouse;
		this.year = year;
	}
}
