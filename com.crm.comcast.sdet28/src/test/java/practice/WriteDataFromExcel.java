package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/VTigerData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		
	
			Sheet sheet = workbook.getSheet("sheet1");
			Row row = sheet.getRow(15);
			row.createCell(6).setCellValue("wipro");
			
			FileOutputStream fos = new FileOutputStream("./src/test/resorces/VTigerData.xlsx");
			workbook.write(fos);
			workbook.close();
			
		} 
	}


