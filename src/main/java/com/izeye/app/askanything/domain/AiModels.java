package com.izeye.app.askanything.domain;

/**
 * AI models.
 *
 * @author Johnny Lim
 */
public enum AiModels {

	/**
	 * For GPT 3.5.
	 */
	GPT_3_5("gpt-3.5-turbo-1106"),

	/**
	 * For GPT 4.
	 */
	GPT_4("gpt-4"),

	/**
	 * For GPT 4 Turbo.
	 */
	GPT_4_TURBO("gpt-4-1106-preview");

	private final String id;

	AiModels(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

}
