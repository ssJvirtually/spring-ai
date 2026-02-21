# OpenRouter Demo

Interactive chat application using OpenRouter API with Spring AI framework.

## Overview

This Spring Boot application demonstrates how to integrate with OpenRouter's API using Spring AI to create an interactive chat interface. The application supports both single responses and streaming responses from various AI models available through OpenRouter.

## Features

- 🤖 **AI Chat Integration**: Connect to OpenRouter API with Spring AI
- 💬 **Interactive CLI**: Command-line interface for real-time conversations
- 🌊 **Streaming Responses**: Real-time streaming of AI responses
- ⚙️ **Configurable**: Externalized configuration for models and parameters
- 📝 **Professional Architecture**: Clean separation of concerns with service layer
- 🛡️ **Error Handling**: Graceful error handling and logging

## Prerequisites

- Java 25 or higher
- Maven 3.6 or higher
- OpenRouter API key

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/ssjvirtually/spring-ai/openrouter-demo.git
cd openrouter-demo
```

### 2. Set Up Environment Variables

Create an environment variable with your OpenRouter API key:

```bash
export OPENROUTER_API_KEY=your_api_key_here
```

Or set it in your system environment variables.

### 3. Build and Run

```bash
# Build the application
mvn clean compile

# Run the application
mvn spring-boot:run
```

Alternatively, you can build and run as an executable JAR:

```bash
mvn clean package
java -jar target/openrouter-demo-0.0.1-SNAPSHOT.jar
```

### 4. Using the Application

Once started, the application will:

1. Display an initial response to a default prompt or your provided argument
2. Enter interactive mode where you can chat with the AI
3. Type "exit" to quit the application

#### Command Line Usage

```bash
# Use default prompt
java -jar target/openrouter-demo-0.0.1-SNAPSHOT.jar

# Provide custom initial prompt
java -jar target/openrouter-demo-0.0.1-SNAPSHOT.jar "What is Spring Boot?"
```

## Configuration

The application uses `application.yaml` for configuration. Key settings include:

### AI Model Configuration

```yaml
spring:
  ai:
    openai:
      api-key: ${OPENROUTER_API_KEY}
      base-url: https://openrouter.ai/api
      chat:
        options:
          model: arcee-ai/trinity-large-preview:free
          temperature: 0.7
```

### Application Settings

```yaml
app:
  chat:
    default-prompt: "Tell me a joke about Java."
    exit-command: "exit"
    welcome-message: "--- Querying LLM ---"
    prompt-prefix: "You: "
    response-prefix: "LLM: "
    exit-message: "Bye 👋"
```

### Logging Configuration

```yaml
logging:
  level:
    dev.ssjvirtually: INFO
    org.springframework.ai: DEBUG
```

## Architecture

The application follows Spring Boot best practices with a clean, layered architecture:

```
src/main/java/dev/ssjvirtually/
├── OpenRouterDemoApplication.java     # Main application class
├── config/
│   └── ChatProperties.java            # Configuration properties
└── service/
    ├── ChatService.java               # AI interaction service
    └── InteractiveChatService.java     # CLI interface service
```

### Key Components

- **OpenRouterDemoApplication**: Entry point and application bootstrap
- **ChatService**: Handles all AI interactions with OpenRouter
- **InteractiveChatService**: Manages the command-line interface
- **ChatProperties**: Externalized configuration management

## Available Models

The application is configured to use `arcee-ai/trinity-large-preview:free` by default, but you can change this in the configuration file. OpenRouter supports various models including:

- OpenAI models (GPT-3.5, GPT-4)
- Anthropic models (Claude)
- Meta models (Llama)
- Google models (Gemini)
- And many more...

Check the [OpenRouter documentation](https://openrouter.ai/docs) for available models.

## Development

### Project Structure

- **Java Version**: 25
- **Spring Boot Version**: 4.0.3
- **Spring AI Version**: 2.0.0-M2
- **Build Tool**: Maven

### Dependencies

- Spring Boot Starter
- Spring AI OpenAI Starter
- Spring Boot Starter Test

### Running Tests

```bash
mvn test
```

### Building for Production

```bash
mvn clean package -Pprod
```

## Environment Variables

| Variable | Required | Description |
|----------|----------|-------------|
| `OPENROUTER_API_KEY` | Yes | Your OpenRouter API key |

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

If you encounter any issues:

1. Check that your OpenRouter API key is correctly set
2. Verify the model you're using is available and has sufficient credits
3. Check the application logs for detailed error messages
4. Open an issue on GitHub with details about your environment and the error

## Acknowledgments

- [Spring AI](https://spring.io/projects/spring-ai) for the AI integration framework
- [OpenRouter](https://openrouter.ai/) for providing access to various AI models
- [Spring Boot](https://spring.io/projects/spring-boot) for the application framework
