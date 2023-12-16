package com.izeye.app.askanything.web;

import com.izeye.app.askanything.service.AnswerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} for APIs.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/api/v1")
public class ApiController {

    private final AnswerService service;

    public ApiController(AnswerService service) {
        this.service = service;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String question) {
        return this.service.ask(question);
    }

}
