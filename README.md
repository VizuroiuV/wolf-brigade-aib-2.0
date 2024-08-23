# The Wolf Brigade - UI framework that validates LLM based chatbot -> https://chat.mistral.ai/chat

This repository contains a set of automated tests for Mistral Chat AI using Selenium with Java. 
The tests are designed to verify the functionality and answers of Mistral Chat AI, reads the questions from the SampleQuestions_Mistral.xlsx, compares the result from Mistral of the entire answer, it searches for a certain
keyword and  calculates a similarity score based on comparison of the excel file and chat bot answer, a clear example of reinforced learning  and ensuring accuracy of the generated data of Mistal Large 2 model.
The Sample Question are basic universal knowledge, but the model responses are different for every query of the same question.



## Table of Contents

- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [Running Tests](#running-tests)
- [Test Scenarios](#test-scenarios)
- [Reporting](#reporting)
- [Contributing](#contributing)
- [License](#license)

## Project Structure

```
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       │   └── com
│       │       └── yourorganization
│       │           └── mistral
│       │               └── tests
│       └── resources
├── pom.xml
└── README.md
```

- **src/main/java**: Contains application code (if any).
- **src/test/java**: Contains test classes and test cases.
- **pom.xml**: Maven configuration file for managing dependencies.
- **README.md**: Project documentation.

## Prerequisites

Before running the tests, ensure you have the following installed:

- Java JDK 8 or higher
- Maven 3.6 or higher
- Chrome/Firefox browser (depending on the target browser for testing)
- Selenium Webdriver version
- IDE (e.g., IntelliJ IDEA, Eclipse) for development and running tests

## Setup and Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/VizuroiuV/wolf-brigade-aib-2.0).git
   cd wolf-brigade-aib-2.0
   ```

2. **Install Dependencies:**

   Use Maven to download and install all necessary dependencies:

   ```bash
   mvn clean install
   ```

3. **Configure Browser Drivers:**

   Ensure that the appropriate WebDriver (e.g., ChromeDriver) is available in your system's PATH, or configure the drivers in the test setup.

## Running Tests

To execute the test suite, run the following Maven command:

```bash
mvn test
```

This will compile the tests and execute them, outputting results to the console and generating a report.

### Running Specific Test

To run a specific test class or method, use the following command:

```bash
mvn -Dtest=TestClassName#methodName test
```

Replace `TestClassName` with the name of the test class and `methodName` with the name of the test method.

## Test Scenarios

The test suite covers various scenarios, including:

- **Login Tests**: Verifies user authentication processes.
- **Chat Functionality Tests**: Ensures proper handling of user inputs and AI responses.
- **Comparing Entire Strings Chat Response**: test and Evaluates the responses as a whole.
- **Validates that proper keywords are present in the chat respone**: Tests that the AI's response has the short answer.
- **Calculates a similarity score comparing the answers from the excel to Mistral chat repsones**: Test and Evaluates the AI's response as a whole.

Each test case is designed to be self-contained, focusing on a specific aspect of Mistral Chat AI.

## Reporting

Test results are automatically generated after each test run. The results can be found in the `target/surefire-reports` directory. 

## Contributing

We welcome contributions to enhance the test suite or add new test cases. Please follow these steps:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/your-feature-name`.
3. Make your changes and commit them: `git commit -m 'Add new feature'`.
4. Push to the branch: `git push origin feature/your-feature-name`.
5. Create a pull request detailing your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

For any questions or issues, feel free to open an issue or contact us. Happy testing!
