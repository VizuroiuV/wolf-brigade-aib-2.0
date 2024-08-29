# The Wolf Brigade - Test automation UI framework that validates LLM based chatbot -> https://chat.mistral.ai/chat 

This repository contains a set of automated tests for Mistral Chat AI using Selenium with Java. 
The tests are designed to verify the functionality and answers of Mistral Chat AI, reads the questions from the SampleQuestions_Mistral.xlsx, compares the result from Mistral of the entire answer, it searches for a certainkeyword and  calculates a similarity score based on comparison of the excel file and chat bot answer, a clear example of reinforced learning  and ensuring accuracy of the generated data of Mistal Large 2 model.
The Sample Question are basic universal knowledge, but the model responses are different for every query of the same question.

The dataset used is GoogleNews-vectors-negative-300. We used this LLM dataset in order to compare the results of Mistral chat with it and calculate a similarity score. The assertion are made per keyword, it also compares the entire strings and calculates the Cosine Similiarity. Briefly put Mistral AI Chat is validated against the excel file and against Google dataset.

The reading of the provided excel file SampleQuestions_Mistral.xls is done in the dedicated class called ExcelOperations.java While writing the result, the method called WriteExcel creates a new xls file called “Answers”  The login is  made and validated in it’s dedicated abstracted class, so it can be easily maintained  and used by anyone, anywhere, Compare class validates the keywords  and entire strings.
We have a main class and a class called Questions for getters and  setters and a SimilarityScore class that calculates the similarity score based on a math formula, the result is printed in th console and it it also stored in the xls “Answers “ file.


## Prerequisites

Before running the tests, ensure you have the following installed:
- Docker desktop running
- Java JDK 8 or higher
- Maven 3.6 or higher
- Chrome/Firefox browser (depending on the target browser for testing)
- Selenium Webdriver version
- IDE (e.g., IntelliJ IDEA, Eclipse) for development and running tests
- Before runiing the tests Download the dataset to your local repo from here -> https://www.kaggle.com/datasets/leadbest/googlenewsvectorsnegative300 


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

## Test Scenarios

The test suite covers various scenarios, including:

- **Login Tests**: Verifies user authentication processes.
- **Chat Functionality Tests**: Ensures proper handling of user inputs and AI responses.
- **Comparing Entire Strings Chat Response**: test and Evaluates the responses as a whole.
- **Validates that proper keywords are present in the chat respone**: Tests that the AI's response has the short answer.
- **Calculates a similarity score comparing the answers from the excel to Mistral chat repsones**: Test and Evaluates the AI's response as a whole.

Each test case is designed to be self-contained, focusing on a specific aspect of Mistral Chat AI.





