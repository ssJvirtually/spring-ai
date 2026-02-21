package dev.ssjvirtually.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.chat")
public class ChatProperties {

    private String defaultPrompt = "Tell me a joke about Java.";
    private String exitCommand = "exit";
    private String welcomeMessage = "--- Querying LLM ---";
    private String promptPrefix = "You: ";
    private String responsePrefix = "LLM: ";
    private String exitMessage = "Bye 👋";

    public String getDefaultPrompt() {
        return defaultPrompt;
    }

    public void setDefaultPrompt(String defaultPrompt) {
        this.defaultPrompt = defaultPrompt;
    }

    public String getExitCommand() {
        return exitCommand;
    }

    public void setExitCommand(String exitCommand) {
        this.exitCommand = exitCommand;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getPromptPrefix() {
        return promptPrefix;
    }

    public void setPromptPrefix(String promptPrefix) {
        this.promptPrefix = promptPrefix;
    }

    public String getResponsePrefix() {
        return responsePrefix;
    }

    public void setResponsePrefix(String responsePrefix) {
        this.responsePrefix = responsePrefix;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }
}
