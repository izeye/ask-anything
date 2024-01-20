package com.izeye.app.askanything.config;

import com.izeye.app.askanything.domain.AiModels;
import org.springframework.ai.autoconfigure.openai.OpenAiConnectionProperties;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for AI.
 *
 * @author Johnny Lim
 */
@Configuration(proxyBeanMethods = false)
public class AiConfig {

	@Bean
	public OpenAiApi openAiApi(OpenAiConnectionProperties openAiConnectionProperties) {
		return new OpenAiApi(openAiConnectionProperties.getApiKey());
	}

	@Bean
	public OpenAiChatClient openAiChatClientWithGpt35(OpenAiApi openAiApi) {
		OpenAiChatClient openAiChatClient = new OpenAiChatClient(openAiApi);
		openAiChatClient.setModel(AiModels.GPT_3_5.getId());
		return openAiChatClient;
	}

	@Bean
	public OpenAiChatClient openAiChatClientWithGpt4(OpenAiApi openAiApi) {
		OpenAiChatClient openAiChatClient = new OpenAiChatClient(openAiApi);
		openAiChatClient.setModel(AiModels.GPT_4.getId());
		return openAiChatClient;
	}

	@Bean
	public OpenAiChatClient openAiChatClientWithGpt4Turbo(OpenAiApi openAiApi) {
		OpenAiChatClient openAiChatClient = new OpenAiChatClient(openAiApi);
		openAiChatClient.setModel(AiModels.GPT_4_TURBO.getId());
		return openAiChatClient;
	}

}
