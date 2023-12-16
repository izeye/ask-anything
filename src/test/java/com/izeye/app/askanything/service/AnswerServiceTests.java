package com.izeye.app.askanything.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link AnswerService}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class AnswerServiceTests {

    @Autowired
    private AnswerService service;

    @Test
    void ask() {
        String answer = this.service.ask("What is your name?");
        System.out.println("answer: " + answer);
        assertThat(answer).isNotEmpty();
    }

}
