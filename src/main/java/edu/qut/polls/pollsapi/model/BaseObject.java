package edu.qut.polls.pollsapi.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	@JsonIgnore
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
