package mavenPack.mavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excelRowReader {
	
	public static final String path = "C:\\Users\\Quennie\\Desktop\\testdata.xlsx";
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	
	public static void loadExcel() throws Exception {
		
		File f = new File(path);
		fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("testreader");
		fis.close();
		
	}
	
	public static Map<String, Map<String, ArrayList<String>>> getData(String key) throws Exception {
		
		Map<String, Map<String, ArrayList<String>>> superMap = new HashMap<String, Map<String,ArrayList<String>>>();
		Map<String, ArrayList<String>> myMap = new HashMap<String, ArrayList<String>>();
		
		excelRowReader.loadExcel(); //call loadExcel method to get the workbook sheet
		
		//to travel  through rows
		for(int i=1; i< sheet.getLastRowNum()+1; i++) {
			
			row = sheet.getRow(i);
			String keyCell = row.getCell(0).getStringCellValue();
			int colNum = row.getLastCellNum();
			ArrayList<String> data = new ArrayList<String>();

			//to travel  through columns
			for(int j=0; j<colNum; j++) {
				String value = row.getCell(j).getStringCellValue();
				
				//if value is empty
				if(value.isEmpty()) {
					value = "null";
				}
				data.add(value); //pushing all the column data into a variable "data" array
				myMap.put(keyCell, data);
			}

			superMap.put("master", myMap);
		}
		return superMap;
	
	}
		
	public static ArrayList<String> getValue(String key) throws Exception {
		
		Map<String, ArrayList<String>> myVal = getData(key).get("master");
		//System.out.println(myVal); //getting all the rows data in the form of key-value pair
		ArrayList<String> returnVal = myVal.get(key);
		
		return returnVal;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("TestCase Row TC_004 :"+getValue("TC_004"));
	}
}
