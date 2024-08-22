import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ExcelOperations excelOperations = new ExcelOperations();

        List<Questions> listOfQuestions = excelOperations.ReadExcel();

        String chatLink = listOfQuestions.get(0).getQuestion();

        System.out.println("Chat Link: "+chatLink);

        for(int i=2 ;i<listOfQuestions.size();i++) {
            System.out.println(listOfQuestions.get(i).getQuestion());
        }

        excelOperations.WriteExcel(listOfQuestions,"test.xlsx");


        //id=":R35l3:" => email field
        // id=":R55l3:" => password

    }



}