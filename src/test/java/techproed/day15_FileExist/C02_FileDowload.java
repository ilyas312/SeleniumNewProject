package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDowload extends TestBase {

    //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
    //"b10 all test cases" dosyasını indirin
    // Dosyanın başarıyla indirilip indirilmediğini test edin.


    @Test
    public void name() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);

        //C:\Users\İLYAS\Downloads\b10 all test cases, code.docx-->Dosya yolu
        File silinecekDosya=new File("C:\\Users\\İLYAS\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

        /*
        File silinecekDosya=new File("C:\\Users\\İLYAS\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

        Eğer localinizden otomasyon ile bir dosya silmek için File class ından onje
        oluşturup dosya yolunuzu içine yerleştiririz ve oluşturduğumuz obje ile delete
        methodunu kullnarak o dosyayı silebiliriz.

        Bunu yapma sebebimiz test classımızı çalıştırdığımızda her çalıştırmada
        yeni bir dosya indirieceği için ordaki dosya kalabalığını önlemiş oluruz.
        Aynı zamanda doğrulama yaparken işimizi garantiye almış oluruz.
         */

        //"b10 all test cases" dosyasını indirin
        WebElement indirilecekDosya = driver.findElement(By.xpath("//a[@href='../download/b10 all test cases, code.docx']"));
        indirilecekDosya.click();

        bekle(5);

        // Dosyanın başarıyla indirilip indirilmediğini test edin.

        /*
        Dosyanın bilgisayarımda download'sa başarıyla indirilip indirilmediğini
        Java ile test edeceğim çünkü selenium web sayfalarını test eder.
        Selenium benim bilgisayarımdaki download'sa müdahale edemez
         */

        //"C:\Users\İLYAS\Downloads\b10 all test cases, code.docx"-->dosya yolu
        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\İLYAS\\Downloads\\b10 all test cases, code.docx")));

        //Daha dinamik hale getirelim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\b10 all test cases, code.docx";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
