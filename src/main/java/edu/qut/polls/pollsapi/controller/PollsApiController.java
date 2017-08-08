package edu.qut.polls.pollsapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.qut.polls.pollsapi.model.Question;
import edu.qut.polls.pollsapi.service.PollsService;
import edu.qut.polls.pollsapi.utils.PollsBuilderUtility;

@RestController
public class PollsApiController {

	@Autowired
	private PollsService pollsService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public String index() throws JsonProcessingException {
		Map<String, String> returnMap = new HashMap<>();
		returnMap.put("url", "/");
		returnMap.put("questions_url", "/questions");
		return new ObjectMapper().writeValueAsString(returnMap);
	}

	@RequestMapping(value = "/questions", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public String questions() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(PollsBuilderUtility.getQuestions());
	}

	@RequestMapping(value = "/questions/{questionId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public String question(@PathVariable("questionId") final Integer pIndex) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(pollsService.getQuestion(pIndex));
	}

	@RequestMapping(value = "/questions/{questionId}/choices/{choiceId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public String choice(@PathVariable("questionId") final Integer pQuestionIndex,
			@PathVariable("choiceId") final Integer pChoiceIndex) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(pollsService.getChoice(pQuestionIndex, pChoiceIndex));
	}

	@RequestMapping(value = "/questions/{questionId}/choices/{choiceId}", method = RequestMethod.POST, produces = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	public String vote(@PathVariable("questionId") final Integer pQuestionIndex,
			@PathVariable("choiceId") final Integer pChoiceIndex) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(pollsService.vote(pQuestionIndex, pChoiceIndex));
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	public String post(@RequestBody final Question pQuestion) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(pollsService.createQuestion(pQuestion));
	}

}
