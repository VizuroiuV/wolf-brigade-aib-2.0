import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class Login {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver128.exe"); // Update this path

        // Initialize WebDriver (ChromeDriver in this case)
        WebDriver driver = new ChromeDriver();

        //Thread.sleep(5000);

        try {
            // Open the desired URL
            driver.get("https://chat.mistral.ai/chat"); // Replace with the URL of your login page

            // Maximize the browser window
            driver.manage().window().maximize();

            //Login
            WebElement emailField = driver.findElement(By.id(":R35l3:"));
            emailField.sendKeys("laurentiu.oprita@nagarro.com");

            WebElement passwordField = driver.findElement(By.id(":R55l3:"));
            passwordField.sendKeys("testtest98@");

            WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in with password')]"));
            signInButton.click();

            Thread.sleep(5000);

            WebElement chatInput = driver.findElement(By.xpath("//textarea[@placeholder='Ask anything!']"));

            Assert.assertTrue(chatInput.isDisplayed());

            chatInput.sendKeys("What is the hardest natural substance on Earth?");

            WebElement sendButton = driver.findElement(By.xpath("//button[@aria-label='Send question']"));
            sendButton.click();

            Thread.sleep(5000);

            WebElement answerElement = driver.findElement(By.xpath("//p[contains(text(), 'diamond')]"));

            String AnswerText = answerElement.getText();

            System.out.println("ANSWER TEXT: "+ AnswerText);

            Compare comparer = new Compare();

            System.out.println(comparer.CompareEntireStrings(AnswerText));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the operation
            driver.quit();
        }
    }
}