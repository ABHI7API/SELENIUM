package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author abhinav
 */

public class ExcelUtility {
	/**
	 * This method is used to read String data from excel
	 * User must pass sheetName,rowIndex.colIndex
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getStringDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {  
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/DemoWebShopProject-1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue(); 
	}
	public boolean getBooleanDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {  
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData/DemoWebShopProject-1.xlsx"); 
		Workbook workbook = WorkbookFactory.create(fis1);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();  
	}
	public double getNumericDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis2=new FileInputStream("./src/test/resources/TestData/DemoWebShopProject-1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis2);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue(); 	
	}
	public LocalDateTime getDateDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis2=new FileInputStream("./src/test/resources/TestData/DemoWebShopProject-1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis2);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue(); 	 

}
}
