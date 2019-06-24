package datewritefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

public class exceldatawrite {



	private static HSSFWorkbook workbook=new HSSFWorkbook();
	private static HSSFSheet sheet;
	private static int rowNum = 0;

	public exceldatawrite (String sheetname) throws Exception
	{

		rowNum=0;
		workbook=new HSSFWorkbook();
		sheet = workbook.createSheet(sheetname);	


	}

	public  void writedata(String mobname,String selname,String mobprice)
	{

		Row row=sheet.createRow(rowNum++);

		Cell cell=row.createCell(0);
		cell.setCellValue(mobname);

		Cell cell1=row.createCell(1);
		cell1.setCellValue(selname);

		Cell cell2=row.createCell(2);
		cell2.setCellValue(mobprice);


	}
	public  void flush() {

		rowNum = 0;

		FileOutputStream outputStream;

		try {

			outputStream = new FileOutputStream("C:\\Users\\shivanand.chachadi\\Desktop\\my2"+ System.currentTimeMillis()+".xls ");
			workbook.write(outputStream);
			workbook.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void font()
	{

		rowNum=0;
		CellStyle style = null;
		HSSFFont font=workbook.createFont();
		font.setBold(true);
		font.setFontName("Arial");
		font.setColor(IndexedColors.BLUE.getIndex());
		style.setFont(font);
		Row row=sheet.createRow(0);
		Cell cel= row.createCell(0);
		cel.setCellValue("Mobile name");
		cel.setCellStyle(style);

		Cell cel1= row.createCell(1);
		cel1.setCellValue("Seller name");
		cel1.setCellStyle(style);

		Cell cel2= row.createCell(2);
		cel2.setCellValue("Price");
		cel2.setCellStyle(style);



	}
}
