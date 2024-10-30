package com.ssafy.commerce.demo.handler;

/**
 * Mattermost 웹훅 페이로드 DTO
 */
public class MattermostPayload {
    private String channel;
    private String text;

    // Getters and setters
    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
