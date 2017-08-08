package edu.qut.polls.pollsapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.qut.polls.pollsapi.PollsException;
import edu.qut.polls.pollsapi.model.Choice;
import edu.qut.polls.pollsapi.model.Question;
import edu.qut.polls.pollsapi.utils.PollsBuilderUtility;

@Service
public class PollsServiceImpl implements PollsService {

	@Override
	public Question getQuestion(final Integer pIndex) {
		List<Question> questions = PollsBuilderUtility.getQuestions();
		if (pIndex == null || (pIndex != null && pIndex < 0) || (pIndex != null && pIndex > questions.size())) {
			throw new PollsException("Incorrect question number selected.");
		}
		return questions.get(pIndex - 1);
	}

	@Override
	public Choice getChoice(final Integer pQuestionIndex, final Integer pChoiceIndex) {
		Question question = getQuestion(pQuestionIndex);
		if (pChoiceIndex == null || (pChoiceIndex != null && pChoiceIndex < 0)
				|| (pChoiceIndex != null && pChoiceIndex > question.getChoices().size())) {
			throw new PollsException("Incorrect choice number selected.");
		}
		return question.getChoices().get(pChoiceIndex - 1);
	}

	@Override
	public Choice vote(final Integer pQuestionIndex, final Integer pChoiceIndex) {
		Choice choice = getChoice(pQuestionIndex, pChoiceIndex);
		choice.setVotes(choice.getVotes() + 1);
		return choice;
	}

	@Override
	public Question createQuestion(final Question pQuestion) {
		if (pQuestion == null || (pQuestion != null && pQuestion.getChoices() == null)
				|| (pQuestion != null && pQuestion.getChoices() != null && pQuestion.getChoices().size() == 0)) {
			throw new PollsException("Incorrect question posted.");
		}
		return PollsBuilderUtility.addQuestion(pQuestion);
	}

}
