package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null ;

	public FileInputStream getFileInputStream ()
	{

		String filepath = System.getProperty("user.dir")+"/src/test/java/Data/Test_Users.xlsx" ;
		File srfFile = new File(filepath) ;

		try {
			fis = new FileInputStream(srfFile) ;
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file is not found :" + e.getMessage());
			System.exit(0);
		}

		return fis ;

	}
	
	public Object [][] GetExcelData () throws IOException {
		
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int totalNumberOfRows = (sheet.getLastRowNum()+1); 
		int totalNumberOfColumns = 4 ;
		
		String [][] arrayExcelData = new String [totalNumberOfRows][totalNumberOfColumns] ;
		
		for (int i = 0; i < totalNumberOfRows; i++) {
			for (int j = 0; j < totalNumberOfColumns; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData [i][j] = row.getCell(j).toString();
				
			}
		}
		
		wb.close();
		return arrayExcelData ;
		
	}

}
