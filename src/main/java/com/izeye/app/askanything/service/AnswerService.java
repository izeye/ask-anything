package com.izeye.app.askanything.service;

import com.izeye.app.askanything.domain.Answer;
import com.izeye.app.askanything.domain.Question;

/**
 * Answer service.
 *
 * @author Johnny Lim
 */
public interface AnswerService {

	Answer ask(Question question);

}
