package webpagestest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelreader1 {
	
	FileInputStream fileexcel=null;
	
	public FileInputStream getFileInputStream()
	{
		String filepath = System.getProperty("user.dir")+"/excel/testing.xlsx";
		File src=new File(filepath);
		
		try {
			fileexcel=new FileInputStream(src);
		} catch (FileNotFoundException e) {
			
			System.out.println("file not found check path");
			System.exit(0);
		}
		return fileexcel;
	}
	
	public Object[][] exceldata() throws IOException
	{
		fileexcel = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fileexcel);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int totalrows= sheet.getLastRowNum()+1;
		int totalcol= 2;
		
		String[][] arrayexcel=new String[totalrows][totalcol];
		
		for (int i=0;totalrows>i;i++)
		{
			for(int j =0;totalcol>j;j++)
			{
				XSSFRow row=sheet.getRow(i);
				arrayexcel[i][j] = row.getCell(j).toString();
			}
			wb.close();
			
		}
		return arrayexcel;
	}

}
