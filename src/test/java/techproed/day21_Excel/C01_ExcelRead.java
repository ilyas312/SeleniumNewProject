package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void readExcelTest1() throws IOException {

        //3. satır 1. sütun değerini yazdırın ve "France" olduğunu test edin

        //Excel dosyasından veri okuyabilmemiz için
        //1- dosya yolunu alırız.
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        //2-Capitals dosyasını bizim sistemimize getirmeliyiz.Dosyayı okuyabilmek için akışa almalıyız.
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3-Dosyayı Workbook a atamalıyız.Java ortamında bir excel dosyası oluşturmalıyız.
        Workbook workbook = WorkbookFactory.create(fis);

        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satir3Sutun1);

        Assert.assertEquals("France", satir3Sutun1);


        //Son satir sayısınız bulunuz
        int sonSatir = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Son Satir Sayisi = " + sonSatir);

        //Excel tablosundaki son satır sayısını getLastRowNum() methodu ile alabiliriz.
        //index olarak verir.


        //Kullanılan satır sayısını bulunuz
        int kullanilanSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("KULLANILAN SATIR SAYISI = " + kullanilanSatirSayisi);


        //Excel tablosundaki kullanılan satır sayısını getPhysicalNumberOfRows()
        // methodu ile alabiliriz index olarak vermez.


    }

    @Test
    public void readExcelTest2() throws IOException {

        //Capitals dosyasındaki tüm verileri yazdırınız

        Map<String, String> capitalsMap = new HashMap<>();
        //Capitasl dosyasındaki tüm verileri koyabileceğimiz en uygun java objesi
        //map'dir.

        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("Sheet1").getLastRowNum();

        for (int i = 0; i < sonSatir; i++) {

            String key = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();

            String value = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            capitalsMap.put(key,value);
        }

        System.out.println(capitalsMap);


    }
}
