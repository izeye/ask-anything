package com.izeye.app.askanything.web;

import org.springframework.ai.client.AiClient;
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

    private final AiClient client;

    public ApiController(AiClient client) {
        this.client = client;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String question) {
        return this.client.generate(question);
    }

}
