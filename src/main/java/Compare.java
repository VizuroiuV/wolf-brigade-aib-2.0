import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Compare {
    public double SimilarityScore(String actualAnswer, String expectedAnswer){

        SimilarityScore sc = new SimilarityScore();
        double similarityScore = sc.similarityScore(actualAnswer,expectedAnswer);
        System.out.println("Similarity Score is: "+ String.valueOf(similarityScore));

        return similarityScore;
    }

    public boolean CompareEntireStrings(String actualAnswer, String expectedAnswer){
        System.out.println("Actual answer: "+actualAnswer);
        System.out.println("Expected answer: "+expectedAnswer);

        //compareTo method returns 0 if both strings are equal
        return expectedAnswer.compareTo(actualAnswer) == 0;

    }

    public boolean SearchByKeywords(String actualAnswer, String keyword){
        String[] keywords =  keyword.split(" ");

        for(int i=0; i<keywords.length;i++){
            if (!actualAnswer.contains(keywords[i]))
                return false;
        }

        return true;
    }
}
