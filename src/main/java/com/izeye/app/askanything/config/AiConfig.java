package com.izeye.app.askanything.config;

import com.izeye.app.askanything.domain.AiModels;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.openai.client.OpenAiClient;
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
	public AiClient openAiClientWithGpt35(OpenAiApi openAiApi) {
		OpenAiClient openAiClient = new OpenAiClient(openAiApi);
		openAiClient.setModel(AiModels.GPT_3_5.getId());
		return openAiClient;
	}

	@Bean
	public AiClient openAiClientWithGpt4(OpenAiApi openAiApi) {
		OpenAiClient openAiClient = new OpenAiClient(openAiApi);
		openAiClient.setModel(AiModels.GPT_4.getId());
		return openAiClient;
	}

	@Bean
	public AiClient openAiClientWithGpt4Turbo(OpenAiApi openAiApi) {
		OpenAiClient openAiClient = new OpenAiClient(openAiApi);
		openAiClient.setModel(AiModels.GPT_4_TURBO.getId());
		return openAiClient;
	}

}
