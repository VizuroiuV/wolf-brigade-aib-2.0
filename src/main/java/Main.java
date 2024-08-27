import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExcelOperations excelOperations = new ExcelOperations();

        List<Questions> listOfQuestions = excelOperations.ReadExcel();

        String chatLink = listOfQuestions.get(0).getQuestion();

        System.out.println("Chat Link: "+chatLink);

        Login lg = new Login();
        lg.Navigate(chatLink);
        for(int i=2 ;i<listOfQuestions.size();i++) {

            Compare compare = new Compare();

            System.out.println("QUESTION " + String.valueOf(i) +": " + listOfQuestions.get(i).getQuestion());
            System.out.println("KEYWORDS: " + listOfQuestions.get(i).getKeywords());

            String actualAnswer = lg.AnswerQuestions(listOfQuestions.get(i).getQuestion(),listOfQuestions.get(i).getKeywords());
            listOfQuestions.get(i).setActualAnswer(actualAnswer);

            System.out.println("ACTUAL ANSWER " + String.valueOf(i) +": " + actualAnswer);
            System.out.println("ACTUAL ANSWER (object) " + String.valueOf(i) +": " + listOfQuestions.get(i).getActualAnswer());

           /* boolean entireString = compare.CompareEntireStrings(listOfQuestions.get(i).getActualAnswer(),listOfQuestions.get(i).getExpectedAnswer());
            boolean compareByKeywords = compare.SearchByKeywords(listOfQuestions.get(i).getActualAnswer(),listOfQuestions.get(i).getKeywords());
            double similarityScore = compare.SimilarityScore(listOfQuestions.get(i).getActualAnswer(),listOfQuestions.get(i).getExpectedAnswer());

            System.out.println(String.valueOf(entireString));
            System.out.println(String.valueOf(compareByKeywords));
            System.out.println(String.valueOf(similarityScore));

            listOfQuestions.get(i).setTextMatching(String.valueOf(entireString));
            listOfQuestions.get(i).setCompareByKeywords(String.valueOf(compareByKeywords));*/

        }

        excelOperations.WriteExcel(listOfQuestions,"Answers.xlsx");

        for(int i=2 ;i<listOfQuestions.size();i++) {
            Compare compare = new Compare();

            boolean entireString = compare.CompareEntireStrings(listOfQuestions.get(i).getActualAnswer(),listOfQuestions.get(i).getExpectedAnswer());
            boolean compareByKeywords = compare.SearchByKeywords(listOfQuestions.get(i).getActualAnswer(),listOfQuestions.get(i).getKeywords());
            double similarityScore = compare.SimilarityScore(listOfQuestions.get(i).getActualAnswer(),listOfQuestions.get(i).getExpectedAnswer());

            System.out.println("Strings are identical: " + String.valueOf(entireString));
            System.out.println("String contains keywords: " + String.valueOf(compareByKeywords));
            System.out.println("Similarity score: " + String.valueOf(similarityScore));

            listOfQuestions.get(i).setTextMatching(String.valueOf(entireString));
            listOfQuestions.get(i).setCompareByKeywords(String.valueOf(compareByKeywords));
            listOfQuestions.get(i).setSimilarityScore(String.valueOf(similarityScore));
        }
    }
}