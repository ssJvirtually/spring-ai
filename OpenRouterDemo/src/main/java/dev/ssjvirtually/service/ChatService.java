package dev.ssjvirtually.service;

import dev.ssjvirtually.config.ChatProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatService {

    private static final Logger logger = LoggerFactory.getLogger(ChatService.class);

    private final ChatClient chatClient;
    private final ChatProperties chatProperties;

    public ChatService(ChatClient.Builder chatClientBuilder, ChatProperties chatProperties) {
        this.chatClient = chatClientBuilder.build();
        this.chatProperties = chatProperties;
    }

    public String getSingleResponse(String prompt) {
        String userPrompt = (prompt != null && !prompt.trim().isEmpty()) ? prompt : chatProperties.getDefaultPrompt();
        
        logger.info("Sending prompt to LLM: {}", userPrompt);
        
        try {
            String response = chatClient.prompt()
                    .user(userPrompt)
                    .call()
                    .content();
            
            logger.info("Received response from LLM");
            return response;
        } catch (Exception e) {
            logger.error("Error getting response from LLM", e);
            return "Sorry, I encountered an error while processing your request.";
        }
    }

    public Flux<String> getStreamResponse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return Flux.just("Please provide a valid input.");
        }

        logger.info("Streaming response for input: {}", input);

        try {
            return chatClient.prompt()
                    .user(input)
                    .stream()
                    .content()
                    .doOnError(error -> logger.error("Error in streaming response", error));
        } catch (Exception e) {
            logger.error("Error initiating stream response", e);
            return Flux.just("Sorry, I encountered an error while processing your request.");
        }
    }

    public boolean shouldExit(String input) {
        return chatProperties.getExitCommand().equalsIgnoreCase(input);
    }
}
