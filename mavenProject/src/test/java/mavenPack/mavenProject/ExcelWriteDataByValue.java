package mavenPack.mavenProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDataByValue {
	@Test
	public void f() throws Exception {
		FileInputStream fis=new FileInputStream("C:\\Users\\Quennie\\Desktop\\login.xlsx");
		FileOutputStream fos=null;
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("loginn");
		XSSFRow row=sheet.getRow(0);
		XSSFCell cell=null;

		int col = 0;
	
		for(int i= 0; i< row.getLastCellNum(); i++) {
			if(row.getCell(i).getStringCellValue().trim().equals("Password")) {
				col = i;
			}
		}
		
		
		row=sheet.getRow(1);

		cell=row.getCell(col);

		cell.setCellValue("Aborted");

		fos=new FileOutputStream("C:\\Users\\Quennie\\Desktop\\login.xlsx");
		workbook.write(fos);
		fos.close();

	}
}
