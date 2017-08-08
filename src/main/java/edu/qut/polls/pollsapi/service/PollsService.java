package edu.qut.polls.pollsapi.service;

import edu.qut.polls.pollsapi.model.Choice;
import edu.qut.polls.pollsapi.model.Question;

public interface PollsService {

	Question getQuestion(final Integer pIndex);

	Choice getChoice(final Integer pQuestionIndex, final Integer pChoiceIndex);

	Choice vote(final Integer pQuestionIndex, final Integer pChoiceIndex);

	Question createQuestion(final Question pQuestion);

}
