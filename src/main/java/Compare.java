import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Compare {
    public void SimilarityScore(){
        /*double similarityScore = calculateSemanticSimilarity(expectedAnswer, actualResponse);
        if (similarityScore < 0.8) {
            throw new AssertionError("The similarity score is too low: " + similarityScore);
        }
        ;*/
    }

    public void CompareEntireStrings(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.browserstack.com/");
        String ActualAnswer = driver.getTitle();
        String ExpectedAnswer = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
        WebElement RealAnswer =driver.findElement(By.xpath("//div[contains(text(),keyword)"));


                Assert.assertEquals(ExpectedAnswer, ActualAnswer);
    }

    public void SearchByKeywords(){
        ;
    }
}
