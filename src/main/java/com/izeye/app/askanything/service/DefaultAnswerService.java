package com.izeye.app.askanything.service;

import com.izeye.app.askanything.domain.AiModels;
import com.izeye.app.askanything.domain.Answer;
import com.izeye.app.askanything.domain.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.client.AiClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default {@link AnswerService}.
 *
 * @author Johnny Lim
 */
@Service
@Slf4j
public class DefaultAnswerService implements AnswerService {

	private final AiClient openAiClientWithGpt35;

	private final AiClient openAiClientWithGpt4;

	private final AiClient openAiClientWithGpt4Turbo;

	public DefaultAnswerService(AiClient openAiClientWithGpt35, AiClient openAiClientWithGpt4,
			AiClient openAiClientWithGpt4Turbo) {
		this.openAiClientWithGpt35 = openAiClientWithGpt35;
		this.openAiClientWithGpt4 = openAiClientWithGpt4;
		this.openAiClientWithGpt4Turbo = openAiClientWithGpt4Turbo;
	}

	@Override
	public List<Answer> ask(Question question) {
		log.info("Question: {}", question);
		String answerTextFromGpt35 = this.openAiClientWithGpt35.generate(question.text());
		Answer answerFromGpt35 = new Answer(answerTextFromGpt35, AiModels.GPT_3_5.getId());
		String answerTextFromGpt4 = this.openAiClientWithGpt4.generate(question.text());
		Answer answerFromGpt4 = new Answer(answerTextFromGpt4, AiModels.GPT_4.getId());
		String answerTextFromGpt4Turbo = this.openAiClientWithGpt4Turbo.generate(question.text());
		Answer answerFromGpt4Turbo = new Answer(answerTextFromGpt4Turbo, AiModels.GPT_4_TURBO.getId());
		List<Answer> answers = List.of(answerFromGpt35, answerFromGpt4, answerFromGpt4Turbo);
		log.info("Answers: {}", answers);
		return answers;
	}

}
