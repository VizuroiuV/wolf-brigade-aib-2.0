import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelOperations {

    List<Questions> questionsList = new ArrayList<Questions>();
    public List<Questions> ReadExcel() throws IOException {

        List<String> lst = new ArrayList<String>();
        //obtaining input bytes from a file
        FileInputStream fis = new FileInputStream(new File("SampleQuestions_Mistral.xlsx"));

        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
//creating a Sheet object to retrieve the object
        XSSFSheet sheet = wb.getSheetAt(0);
//evaluating cell type
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

        for (Row row : sheet) {
            String[] fields = new String[6]; // Array to store values for the 6 fields

            int i = 0;
            for (Cell cell : row) {
                if (i >= 6) break; // Ensure we don't exceed 6 fields

                switch (cell.getCellType()) {
                    case STRING:
                        fields[i] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            fields[i] = cell.getDateCellValue().toString();
                        } else {
                            fields[i] = String.valueOf(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        fields[i] = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        CellValue cellValue = wb.getCreationHelper().createFormulaEvaluator().evaluate(cell);
                        switch (cellValue.getCellType()) {
                            case STRING:
                                fields[i] = cellValue.getStringValue();
                                break;
                            case NUMERIC:
                                fields[i] = String.valueOf(cellValue.getNumberValue());
                                break;
                            case BOOLEAN:
                                fields[i] = String.valueOf(cellValue.getBooleanValue());
                                break;
                            default:
                                fields[i] = "Unknown Formula Result";
                        }
                        break;
                    default:
                        fields[i] = "Unknown Cell Type";
                }
                i++;
            }

            // If there are exactly 6 fields, create a DataObject and add it to the list
            if (fields.length == 6) {
                Questions q = new Questions(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
                questionsList.add(q);
            }
        }


        return questionsList;
    }

    public void WriteExcel(List<Questions> questionsList, String fileName) throws IOException {
        // Create a new workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Answers");

        // Create a header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Question", "ExpectedAnswer", "Keywords", "SimilarityScore", "TextMatching", "CompareByKeywords"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Write the data from questionsList to the sheet
        int rowNum = 1; // Start writing after the header

        System.out.println("Number of lines: "+ questionsList.size());
        for (Questions q : questionsList) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(q.getQuestion());
            row.createCell(1).setCellValue(q.getExpectedAnswer());
            row.createCell(2).setCellValue(q.getKeywords());
            row.createCell(3).setCellValue(q.getSimilarityScore());
            row.createCell(4).setCellValue(q.getTextMatching());
            row.createCell(5).setCellValue(q.getCompareByKeywords());
        }


        // Adjust column widths to fit the content
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        }

        // Close the workbook
        workbook.close();
    }
}
