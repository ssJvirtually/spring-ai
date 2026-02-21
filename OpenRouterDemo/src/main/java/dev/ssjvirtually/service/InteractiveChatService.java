package dev.ssjvirtually.service;

import dev.ssjvirtually.config.ChatProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Scanner;

@Service
public class InteractiveChatService {

    private static final Logger logger = LoggerFactory.getLogger(InteractiveChatService.class);

    private final ChatService chatService;
    private final ChatProperties chatProperties;
    private final Scanner scanner;

    public InteractiveChatService(ChatService chatService, ChatProperties chatProperties) {
        this.chatService = chatService;
        this.chatProperties = chatProperties;
        this.scanner = new Scanner(System.in);
    }

    public void startInteractiveSession(String initialPrompt) {
        try {
            handleInitialPrompt(initialPrompt);
            startChatLoop();
        } catch (Exception e) {
            logger.error("Error during interactive chat session", e);
        } finally {
            scanner.close();
        }
    }

    private void handleInitialPrompt(String initialPrompt) {
        System.out.println("\n" + chatProperties.getWelcomeMessage());
        String response = chatService.getSingleResponse(initialPrompt);
        System.out.println("Response:\n" + response);
    }

    private void startChatLoop() {
        while (true) {
            String userInput = getUserInput();
            
            if (chatService.shouldExit(userInput)) {
                System.out.println(chatProperties.getExitMessage());
                break;
            }

            streamResponse(userInput);
        }
    }

    private String getUserInput() {
        System.out.print("\n" + chatProperties.getPromptPrefix());
        return scanner.nextLine();
    }

    private void streamResponse(String input) {
        System.out.print(chatProperties.getResponsePrefix());
        
        Flux<String> responseStream = chatService.getStreamResponse(input);
        responseStream
                .doOnNext(System.out::print)
                .doOnComplete(() -> System.out.println())
                .blockLast();
    }
}
