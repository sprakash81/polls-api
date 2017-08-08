package edu.qut.polls.pollsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.qut.polls.pollsapi.utils.PollsBuilderUtility;

@SpringBootApplication
public class PollsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollsApiApplication.class, args);
		// initialise the question bank
		PollsBuilderUtility.initialise();
	}
}
