package DataDrivenConcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePoiConcept {

	public static void main(String[] args) throws IOException {
		
		String excelFilePath = "D:\\Automation\\JavaBasics\\org.javabasic\\dataDriven.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		
		XSSFWorkbook excelWorkBook = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = excelWorkBook.getSheetAt(0);
		
		//1. Using For Loop , retrieve all the values from the excel file
		
		int rowCount = sheet.getLastRowNum(); // this will give the total row count in the sheet
		int cellCount = sheet.getRow(1).getLastCellNum(); // this will give the total cell count in each row
		
		for(int i=0;i<=rowCount; i++) // this loop is for row
		{
			XSSFRow row = sheet.getRow(i); // go to the first row in excel sheet
			
			for(int c=0;c<cellCount;c++)  // this loop is for cell
			{
				XSSFCell cell = row.getCell(c); // it will go to each cell of the row
				switch(cell.getCellType()) // this method will check what is the data type of the cell and based on that switch loop will work 
				{
				case STRING:  System.out.print(cell.getStringCellValue()); break;
				case NUMERIC: System.out.print(cell.getStringCellValue()); break;
				case BOOLEAN: System.out.print(cell.getStringCellValue()); break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		
		//2. Using Iterator:
		
			Iterator rowIterator =sheet.iterator(); // this method will store all the rows along with the cells and we can retrieve all the rows
			while (rowIterator.hasNext())
			{
				XSSFRow row1 =(XSSFRow) rowIterator.next(); // here Object type of row1 is XXXFRow 
				Iterator cellIterator = row1.cellIterator(); // in the particular row, this will capture all the cells and store them in cell iterator
				
				while (cellIterator.hasNext())
				{
					XSSFCell cell1 = (XSSFCell) cellIterator.next();
					switch(cell1.getCellType()) // this method will check what is the data type of the cell and based on that switch loop will work 
					{
					case STRING:  System.out.print(cell1.getStringCellValue()); break;
					case NUMERIC: System.out.print(cell1.getStringCellValue()); break;
					case BOOLEAN: System.out.print(cell1.getStringCellValue()); break;
					}
					System.out.print(" | ");
				}
				System.out.println();
			}
			
		
	}

}
