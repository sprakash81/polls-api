package edu.qut.polls.pollsapi.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.qut.polls.pollsapi.model.Choice;
import edu.qut.polls.pollsapi.model.Question;

public final class PollsBuilderUtility {

	private static final List<Question> questionBank = new ArrayList<>();

	private PollsBuilderUtility() {
		// private constructor
	}

	public static List<Question> getQuestions() {
		return questionBank;
	}

	public static void initialise() {
		addQuestion("Favourite programming language?", "Swift", "Python", "Objective-C", "Ruby");
	}

	public static Question addQuestion(final String pQuestion, final String... pChoices) {
		Question question = new Question();
		question.setId(questionBank.size() + 1);
		question.setPublished_at(Calendar.getInstance().getTime());
		question.setQuestion(pQuestion);
		List<Choice> choices = new ArrayList<>(pChoices.length);
		for (String choiceStr : pChoices) {
			Choice choice = new Choice();
			choice.setId(choices.size() + 1);
			choice.setChoice(choiceStr);
			choice.setQuestion_id(question.getId());
			Double randomNumber = new Double(Math.random() * 100);
			choice.setVotes(randomNumber.longValue());
			choices.add(choice);
		}
		question.setChoices(choices);
		questionBank.add(question);
		return question;
	}

	public static Question addQuestion(final Question pQuestion) {
		pQuestion.setId(questionBank.size() + 1);
		pQuestion.setPublished_at(Calendar.getInstance().getTime());
		int index = 0;
		for (Choice choice : pQuestion.getChoices()) {
			choice.setId(index++);
			choice.setQuestion_id(pQuestion.getId());
		}
		questionBank.add(pQuestion);
		return pQuestion;
	}

}
