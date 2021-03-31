package com.cg.springcore.a5;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Required;
@SuppressWarnings("deprecation")
public class Author {
	
	private String authorName;
	private int authorId;
	

	private Publisher publisher;
	public Publisher getPublisher() {
		return publisher;
	}
	@Inject
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getAuthorName() {
		return authorName;
	}
   @Required
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(String authorName, int authorId, Publisher publisher) {
		super();
		this.authorName = authorName;
		this.authorId = authorId;
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", authorId=" + authorId + ", publisher=" + publisher + "]";
	}
}
