import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // Update this path

        // Initialize WebDriver (ChromeDriver in this case)
        WebDriver driver = new ChromeDriver();

        try {
            // Open the desired URL
            driver.get("https://chat.mistral.ai/chat"); // Replace with the URL of your login page

            // Maximize the browser window
            driver.manage().window().maximize();

            //Click sign up

            //Sign in

            //Login
            WebElement emailField = driver.findElement(By.id(""));
            emailField.sendKeys("");

            WebElement passwordField = driver.findElement(By.id(""));
            passwordField.sendKeys("");

            WebElement firstName = driver.findElement(By.id(""));
            firstName.sendKeys("");

            WebElement lastName = driver.findElement(By.id(""));
            lastName.sendKeys("");

            WebElement signInButton = driver.findElement(By.id("signIn"));
            signInButton.click();


            //Login
            WebElement emailField2 = driver.findElement(By.id(""));
            emailField.sendKeys("");

            WebElement passwordField2 = driver.findElement(By.id(""));
            passwordField.sendKeys("");

            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();

            // Optional: Wait for a few seconds to observe the result (not a good practice for production)
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the operation
            driver.quit();
        }
    }
}