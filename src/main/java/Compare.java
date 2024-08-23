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

    public boolean CompareEntireStrings(String actualAnswer){
        //WebDriver driver = new ChromeDriver();
        //driver.navigate().to("https://www.browserstack.com/");
        //String actualAnswer = driver.getTitle();
        String expectedAnswer = "The hardest natural substance on Earth is diamond. Diamonds are composed of carbon atoms arranged in a specific crystal structure called a diamond cubic, which gives them their exceptional hardness and strength. On the Mohs scale of mineral hardness, diamond is rated as a 10, which is the highest rating. This extreme hardness makes diamonds highly valued for both their aesthetic beauty in jewelry and their industrial applications, such as in cutting tools and abrasives.";
        //WebElement RealAnswer =driver.findElement(By.xpath("//div[contains(text(),keyword)"));

        System.out.println("ACTUAL ANSWER: "+actualAnswer);
        System.out.println("EXPECTED ANSWER: "+expectedAnswer);
        //compareTo method returns 0 if both strings are equal
        return expectedAnswer.compareTo(actualAnswer) == 0;

    }

    public void SearchByKeywords(){
        ;
    }
}
