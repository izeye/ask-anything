package com.izeye.app.askanything.service;

import org.springframework.ai.client.AiClient;
import org.springframework.stereotype.Service;

/**
 * Default {@link AnswerService}.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultAnswerService implements AnswerService {

    private final AiClient client;

    public DefaultAnswerService(AiClient client) {
        this.client = client;
    }

    @Override
    public String ask(String question) {
        return this.client.generate(question);
    }

}
