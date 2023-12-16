package com.izeye.app.askanything.service;

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
    public String ask(String question) {
        String answer = this.client.generate(question);
        log.info("Question: {}", question);
        log.info("Answer: {}", answer);
        return answer;
    }

}
