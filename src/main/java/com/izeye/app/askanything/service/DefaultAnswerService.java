package com.izeye.app.askanything.service;

import com.izeye.app.askanything.domain.AiModels;
import com.izeye.app.askanything.domain.Answer;
import com.izeye.app.askanything.domain.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.OpenAiChatClient;
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

	private final OpenAiChatClient openAiChatClientWithGpt35;

	private final OpenAiChatClient openAiChatClientWithGpt4;

	private final OpenAiChatClient openAiChatClientWithGpt4Turbo;

	public DefaultAnswerService(OpenAiChatClient openAiChatClientWithGpt35, OpenAiChatClient openAiChatClientWithGpt4,
			OpenAiChatClient openAiChatClientWithGpt4Turbo) {
		this.openAiChatClientWithGpt35 = openAiChatClientWithGpt35;
		this.openAiChatClientWithGpt4 = openAiChatClientWithGpt4;
		this.openAiChatClientWithGpt4Turbo = openAiChatClientWithGpt4Turbo;
	}

	@Override
	public List<Answer> ask(Question question) {
		log.info("Question: {}", question);
		String answerTextFromGpt35 = this.openAiChatClientWithGpt35.generate(question.text());
		Answer answerFromGpt35 = new Answer(answerTextFromGpt35, AiModels.GPT_3_5.getId());
		String answerTextFromGpt4 = this.openAiChatClientWithGpt4.generate(question.text());
		Answer answerFromGpt4 = new Answer(answerTextFromGpt4, AiModels.GPT_4.getId());
		String answerTextFromGpt4Turbo = this.openAiChatClientWithGpt4Turbo.generate(question.text());
		Answer answerFromGpt4Turbo = new Answer(answerTextFromGpt4Turbo, AiModels.GPT_4_TURBO.getId());
		List<Answer> answers = List.of(answerFromGpt35, answerFromGpt4, answerFromGpt4Turbo);
		log.info("Answers: {}", answers);
		return answers;
	}

}
