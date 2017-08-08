package edu.qut.polls.pollsapi;

public class PollsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PollsException() {
		new PollsException("Exception occurred");
	}

	public PollsException(final String exceptionStr) {
		new PollsException(exceptionStr);
	}

	public PollsException(final Exception e) {
		new PollsException(e);
	}
}
