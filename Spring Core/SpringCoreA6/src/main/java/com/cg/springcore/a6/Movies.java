package com.cg.springcore.a6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:dbConfig.properties")
public class Movies {
	
	
	private BollywoodMovies bolMovies;
	private HollywoodMovies holMovies;
	
	@Autowired
	public Movies() {}

	
	
	public Movies(BollywoodMovies bolMovies, HollywoodMovies holMovies) {
		super();
		this.bolMovies = bolMovies;
		this.holMovies = holMovies;
	}



	public BollywoodMovies getBolMovies() {
		return bolMovies;
	}



	public void setBolMovies(BollywoodMovies bolMovies) {
		this.bolMovies = bolMovies;
	}



	public HollywoodMovies getHolMovies() {
		return holMovies;
	}



	public void setHolMovies(HollywoodMovies holMovies) {
		this.holMovies = holMovies;
	}



	@Override
	public String toString() {
		return "Movies [bolMovies=" + bolMovies + ", holMovies=" + holMovies + "]";
	}
	

	
	
}
