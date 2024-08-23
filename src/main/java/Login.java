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

        Thread.sleep(5000);

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

            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();

            // Optional: Wait for a few seconds to observe the result (not a good practice for production)
            Thread.sleep(5000);

            WebElement chatInput =driver.findElement(By.xpath("//textarea[contains(text(),'Ask anything!')]"));


            Assert.assertTrue(chatInput.isDisplayed());



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the operation
            driver.quit();
        }
    }
}