package edu.qut.polls.pollsapi.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Question extends BaseObject {

	private static final long serialVersionUID = 1L;

	private String question;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	private Date published_at;
	private List<Choice> choices;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getPublished_at() {
		return published_at;
	}

	public void setPublished_at(Date published_at) {
		this.published_at = published_at;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public String getUrl() {
		return "/questions/" + getId();
	}

}
