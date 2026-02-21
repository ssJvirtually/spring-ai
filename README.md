# Spring AI Examples

This repository contains a collection of example applications demonstrating the capabilities of [Spring AI](https://spring.io/projects/spring-ai) with various Large Language Models (LLMs) and tools.

Spring AI provides a unified interface for interacting with different AI providers, making it easy to switch between models and integrate AI features into your Spring Boot applications.

## 🚀 Examples

### [OpenRouter Demo](./OpenRouterDemo)
An interactive CLI chat application that uses the **OpenRouter API** to access a wide variety of LLMs (OpenAI, Anthropic, Google, Meta, etc.).
- **Key Features**: Streaming responses, interactive mode, externalized configuration.
- **Tech Stack**: Spring Boot 4.0.3, Spring AI 2.0.0-M2, Java 25.

---

## 🛠️ Prerequisites

To run these examples, you will need:
- **Java 25** or higher
- **Maven 3.6** or higher
- API keys for the respective AI providers (e.g., OpenRouter, OpenAI, etc.)

## 📖 Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ssjvirtually/spring-ai-examples.git
   cd spring-ai-examples
   ```

2. **Navigate to an example**:
   ```bash
   cd OpenRouterDemo
   ```

3. **Configure your API keys**:
   Most examples require an API key set as an environment variable. For OpenRouter:
   ```bash
   export OPENROUTER_API_KEY=your_api_key_here
   ```

4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

## 🏗️ General Project Structure

Each subdirectory in this repository is a self-contained Spring Boot project:
- `src/main/java`: Source code following clean architecture.
- `src/main/resources`: Configuration files (`application.yaml`).
- `pom.xml`: Project dependencies and build configuration.

## 🤝 Contributing

Contributions are welcome! If you have a new example or an improvement to an existing one:
1. Fork the repository.
2. Create a new branch.
3. Submit a Pull Request.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
