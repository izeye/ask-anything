package com.izeye.app.askanything.service;

import com.izeye.app.askanything.domain.Answer;
import com.izeye.app.askanything.domain.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.client.AiClient;
import org.springframework.stereotype.Service;

/**
 * Default {@link AnswerService}.
 *
 * @author Johnny Lim
 */
@Service
@Slf4j
public class DefaultAnswerService implements AnswerService {

	private final AiClient client;

	public DefaultAnswerService(AiClient client) {
		this.client = client;
	}

	@Override
	public Answer ask(Question question) {
		log.info("Question: {}", question);
		String answerText = this.client.generate(question.text());
		Answer answer = new Answer(answerText);
		log.info("Answer: {}", answer);
		return answer;
	}

}
