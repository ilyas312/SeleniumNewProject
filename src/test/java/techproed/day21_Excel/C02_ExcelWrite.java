package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {

    @Test
    public void excelWriteTest01() throws IOException {

        //Bir nüfus sütunu oluşturunuz
        //Başkent nüfuslarını excell dosyasına yazınız
        //(D.C: 1000,Paris:1100,Londra:1200,Ankara:1300)

        String dosyaYolu="src/test/java/resourses/Capitals (2).xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NÜFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1000");
        workbook.getSheet("Sheet2").getRow(2).createCell(2).setCellValue(1100);
        workbook.getSheet("Sheet2").getRow(2).createCell(2).setCellValue(1200);
        workbook.getSheet("Sheet2").getRow(2).createCell(2).setCellValue(1300);
        //Excel de bir hücre oluşturmak için createCell() methodu kullanılır.
        //Hücre içine yazdıracağımız değer için setCellValue() methodu kullanılır.

        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        //Dataları bizim class ımızdan Capitals dosyasına göndereceğiz

        workbook.write(fos);
        //workbook taki dataları fos a yazdık.




    }
}
