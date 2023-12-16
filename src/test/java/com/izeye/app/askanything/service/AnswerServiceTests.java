package com.izeye.app.askanything.service;

import com.izeye.app.askanything.domain.Answer;
import com.izeye.app.askanything.domain.Question;
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
        Question question = new Question("What is your name?", "1.2.3.4");
        Answer answer = this.service.ask(question);
        assertThat(answer).isNotNull();
    }

}
