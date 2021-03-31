package com.cg.springcore.a5;

import org.springframework.beans.factory.annotation.Required;

@SuppressWarnings("deprecation")
public class Publisher {	
	private String publisherName;
	private int publisherId;
	public String getPublisherName() {
		return publisherName;
	}
	@Required
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public Publisher(String publisherName, int publisherId) {
		super();
		this.publisherName = publisherName;
		this.publisherId = publisherId;
	}
	public Publisher() {

	}
	@Override
	public String toString() {
		return "Publisher [publisherName=" + publisherName + ", publisherId=" + publisherId + "]";
	}
	
}
