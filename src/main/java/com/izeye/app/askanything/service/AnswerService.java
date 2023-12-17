package com.izeye.app.askanything.service;

import com.izeye.app.askanything.domain.Answer;
import com.izeye.app.askanything.domain.Question;

import java.util.List;

/**
 * Answer service.
 *
 * @author Johnny Lim
 */
public interface AnswerService {

	List<Answer> ask(Question question);

}
