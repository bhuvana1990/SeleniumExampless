package mavenPack.mavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excelSheetReader {
	
	public static final String path = "C:\\Users\\Quennie\\Documents\\testCase.xlsx";
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	
	public static void loadExcel() throws Exception {
		
		File f = new File(path);
		fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("TestData");
		fis.close();
		
	}
	
	public static Map<String, Map<String, String>> getData() throws Exception {
		
		Map<String, Map<String, String>> superMap = new HashMap<String, Map<String,String>>();
		Map<String, String> myMap = new HashMap<String, String>();
		
		excelSheetReader.loadExcel(); //call loadExcel method to get the workbook sheet
		
		//to travel  through rows
		for(int i=1; i< sheet.getLastRowNum()+1; i++) {
			
			row = sheet.getRow(i);
			String keyCell = row.getCell(0).getStringCellValue();
			int colNum = row.getLastCellNum();
			
			for(int j=1; j<colNum; j++) {
				String value = row.getCell(j).getStringCellValue();
				myMap.put(keyCell, value);
			}
			superMap.put("master", myMap);
		}	
		return superMap;
	
	}
	
	public static String getValue(String key) throws Exception {
		
		Map<String, String> myVal = getData().get("master");
		String returnVal = myVal.get(key);
		
		return returnVal;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(getValue("amazonUrl"));
	}
}
