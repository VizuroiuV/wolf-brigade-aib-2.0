import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    WebDriverWait wait;

    public Login() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver128.exe");
        }
        ChromeDriverService service = new ChromeDriverService.Builder().usingPort(9515).build(); // Port number should be unique
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 60);
    }
    // Initialize WebDriver (ChromeDriver in this case)

    public String AnswerQuestions(String question, String keyword) throws InterruptedException {
        WebElement chatInput = driver.findElement(By.xpath("//textarea[@placeholder='Ask anything!']"));

        Assert.assertTrue(chatInput.isDisplayed());

        chatInput.sendKeys(question);

        WebElement sendButton = driver.findElement(By.xpath("//button[@aria-label='Send question']"));
        sendButton.click();

        //Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOf(sendButton));

        String keywords[] = keyword.split(" ");
        String key = keywords[0];
        WebElement answerElement = driver.findElement(By.xpath("//p[contains(text(), '" + keywords[0] + "')]"));

        System.out.println("Keyword: " + keywords[0]);

        //WebElement answerElement = driver.findElement(By.xpath("//p[contains(text(), 'diamond')]"));


        System.out.println("Answer: " + answerElement.getText());

        return answerElement.getText();

    }

    public void Navigate(String link) {
        try {
            // Open the desired URL
            driver.get(link); // Replace with the URL of your login page

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


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

    }
}