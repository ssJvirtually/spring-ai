package dev.ssjvirtually;

import dev.ssjvirtually.service.InteractiveChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenRouterDemoApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OpenRouterDemoApplication.class);

    private final InteractiveChatService interactiveChatService;

    public OpenRouterDemoApplication(InteractiveChatService interactiveChatService) {
        this.interactiveChatService = interactiveChatService;
    }

    public static void main(String[] args) {
        logger.info("Starting OpenRouter Demo Application");
        SpringApplication.run(OpenRouterDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String initialPrompt = args.length > 0 ? String.join(" ", args) : null;
        logger.info("Starting interactive chat session with initial prompt: {}", initialPrompt);
        
        interactiveChatService.startInteractiveSession(initialPrompt);
    }
}

