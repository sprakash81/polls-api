package edu.qut.polls.pollsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Choice extends BaseObject {

	private static final long serialVersionUID = 1L;

	private int question_id;
	private String choice;
	private Long votes;

	public Choice() {
	}

	public Choice(final String pChoice) {
		this.choice = pChoice;
		this.votes = 0L;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	@JsonIgnore
	public int getQuestion_id() {
		return question_id;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public String getUrl() {
		return "/questions/" + question_id + "/choices/" + getId();
	}

}
