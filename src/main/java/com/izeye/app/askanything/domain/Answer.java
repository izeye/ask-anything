package com.izeye.app.askanything.domain;

/**
 * Answer.
 *
 * @param text answer text
 * @param model AI model that the answer was generated from
 * @author Johnny Lim
 */
public record Answer(String text, String model) {
}
