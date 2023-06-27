package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {
    @Test
    public void excelReadTest01() throws IOException {


       // Excel dosyasınadn veri oluşturabilmemiz için
       //     1- Dosya yolunu alırız
            String dosyaYolu="src/test/java/resourses/Capitals (2).xlsx";

       //    2-Capitals dosyasını bizim sistemimize getirmliyiz.Dosyayı okuıyabilmek için akışa almalıyız.
        FileInputStream fis=new FileInputStream(dosyaYolu);

       //3- Dosyayı Workbook a atamalıyız.Java ortamında bir excel dosyası oluşturmalıyız
        Workbook workbook = WorkbookFactory.create(fis);

      // 4- sayfayı(sheet) secmeliyiz
        Sheet sheet = workbook.getSheet("Sheet1");

      // satırı(row) seçmeliyiz
        Row row = sheet.getRow(0);//1. satır index 0  dan başlar.

      // hücreyi(cell) seçmeliyiz
        Cell cell = row.getCell(0);//1. sütun index 0 dan başlar.


    }

    @Test
    public void readExcel02() throws IOException {
        // KISA YÖNTEM

        // 1.satır 1.sütundaki bilgiyi yazdırınız

        String dosyaYolu="src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun1=workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();

        System.out.println(satir1Sutun1);

    }

    @Test
    public void readExcelTest03() throws IOException {

        //1.satir 2.sütundaki hücreyi yazdırın

        String dosyaYolu="src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun2=workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();

        System.out.println(satir1Sutun2);


    }
}
