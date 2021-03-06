package mavenPack.mavenProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderAPI {
	public FileInputStream fis=null;
	public FileOutputStream fos=null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	String xfilePath;
	
		
	
	public ExcelReaderAPI(String xfilePath) throws Exception 
	{
		this.xfilePath=xfilePath;
		fis=new FileInputStream(xfilePath);
		workbook=new XSSFWorkbook(fis);
		fis.close();
	}


	public int getRowCount(String sheetName)
	{
		sheet= workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()+1;
		return rowCount;
	}
	
	public int columnCount(String sheetName)
	{
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}
	
	
	
	//Reading cell data from Excel by using Column Number
	public String getCellData(String sheetName,int colNum,int rowNum)
	{
		try
		{
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			
			if(cell.getCellTypeEnum()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
					Date date=cell.getDateCellValue();
					cellValue=dt.format(date);	
				}
				return cellValue;
			}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
				
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "No matching value";
		}
	}
	
	
	//Reading cell data from Excel by using Column Name
	public String getCellData(String sheetName,String colName,int rowNum)
	{
		try
		{
			int colNum=-1;
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			
			if(cell.getCellTypeEnum()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
					Date date=cell.getDateCellValue();
					cellValue=dt.format(date);	
				}
				return cellValue;
			}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "No matching value";
		}
		
		
	}
	
	
	//Writing cell data to Excel by using Column Number
	public boolean setCellData(String sheetName,int colNum,int rowNum,String value)
	{
		
		try
		{
			sheet=workbook.getSheet(sheetName);
			
			row=sheet.getRow(rowNum);
			//if(row==null)
				//row=sheet.createRow(rowNum);
			
			cell=row.getCell(colNum);
			//if(cell==null)
				//cell=row.createCell(colNum);
		
			
			cell.setCellValue(value);
			
			fos=new FileOutputStream(xfilePath);
			workbook.write(fos);
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	//Writing cell data to Excel by using Column Name
	public  boolean setCellData(String sheetName,String colName,int rowNum, String value)
	{
			
			try
			{
				int colNum = -1;
				sheet=workbook.getSheet(sheetName);
				
				row=sheet.getRow(0);
				String result = " ";
			    int resultCol = -1;
			    
			    //method-1
			    //to set data with column name, we need to get column index of the column name cell
				/*for(Cell cell1 : row){
			        result = cell1.getStringCellValue();
			        if (result.equals(colName)){
			            resultCol = cell1.getColumnIndex(); 
			           // System.out.println(result+" "+resultCol);
			         }
			    }*/
			    
			    //method-2
			    for(int i=0;i<row.getLastCellNum();i++)
				{
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
					{
						colNum=i;
					}
				}

				row = sheet.getRow(rowNum-1);
	           	cell = row.getCell(colNum);

				cell.setCellValue(value);

				fos=new FileOutputStream(xfilePath);
				workbook.write(fos);
				fos.close();				
			 				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("no matching");
			}
			return true;
		}

		public void  getRowData(int rowNum, String rowName, String Sheetpath) {
			sheet = workbook.getSheet(Sheetpath);
			row = sheet.getRow(rowNum);
			for(int i=0; i<=row.getLastCellNum(); i++) {
				cell = row.getCell(i);
				System.out.println(cell);
			}
			
			Iterator<Row> rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext()) {
				row = (XSSFRow) rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					
//					if(rowName.equals(cellIterator.next().getStringCellValue().trim())) {
						cell = (XSSFCell) cellIterator.next();
						System.out.println(cell);
//					}
				}
//				cell = (XSSFCell) cellIterator.next();
				
			}
			
		}
}
