package com.izeye.app.askanything.domain;

/**
 * Question.
 *
 * @param text question text
 * @param ipAddress source IP address
 *
 * @author Johny Lim
 */
public record Question(String text, String ipAddress) {
}
