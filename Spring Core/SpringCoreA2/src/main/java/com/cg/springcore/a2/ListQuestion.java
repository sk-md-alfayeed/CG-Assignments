package com.cg.springcore.a2;
import java.util.List;

public class ListQuestion {
	private int questionId;
	private String question;
	private List<String> answers;
	public int getQuestionId() {
		return questionId;
	}
	public ListQuestion() {
	}
	public ListQuestion(int questionId, String question, List<String> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "ListQuestion [questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
	}

	
	
}
