/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ctb.askanything.answer.service;

import java.util.regex.Pattern;

import com.ctb.askanything.api.domain.Answer;
import com.ctb.askanything.api.domain.Question;
import com.ctb.askanything.api.service.AnswerEngine;

/**
 * Fallback answer engine.
 *
 * This is an answer engine questioning the original question.
 *
 * @author Johnny Lim
 */
public class FallbackAnswerEngine implements AnswerEngine {

	private static final String TEMPLATE_ANSWER = "Are you asking \"{body}\"?";
	private static final String PLACEHOLDER_BODY = "{body}";

	private static final String REGEX_ANSWER = "Are you asking \"[^\"]+\"\\?";
	private static final Pattern PATTERN_ANSWER = Pattern.compile(REGEX_ANSWER);

	@Override
	public Answer answer(Question question) {
		String answer = TEMPLATE_ANSWER.replace(PLACEHOLDER_BODY, question.getBody());
		return new Answer(question, answer);
	}

	public static boolean isFallbackAnswer(String answer) {
		return PATTERN_ANSWER.matcher(answer).matches();
	}

}
