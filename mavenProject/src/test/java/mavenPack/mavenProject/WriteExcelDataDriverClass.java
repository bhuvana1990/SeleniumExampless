package mavenPack.mavenProject;

public class WriteExcelDataDriverClass {
	
	public static void main(String[] args) throws Exception 
	{
		ExcelReaderAPI e=new ExcelReaderAPI("C:\\Users\\Quennie\\Desktop\\testdata.xlsx");
		
//		System.out.println("------Writing cell data to Excel by using Column Number--------");
//		e.setCellData("login", 3, 4, "ravi");
//		
//		
//		System.out.println("*********************************************");
		
		
//		System.out.println("------Writing cell data to Excel by using Column Name--------");
//		e.setCellData("login", "DateCreated", 2, "Failed");
		
		e.getRowData(4, "TC_004", "testreader");
	}

}
