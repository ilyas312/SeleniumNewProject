package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {
    /*

    SCREENSHOT

   Seleniumda tüm ekran görüntüsünüalabilmek için TakesScreenShot arayüzünden
   bir obje oluşturup driver a eşitleriz.Arayüzler farklı olduğu için casting
   yaparız ve bu oluşturduğumuz obje ile getSreenShotAs methodu ile sayfanın
   resmini alırız.Almış olduğumuz resmi projemizde nereye kaydedeceksek oranın
   yolunu belirtiriz.

     */

    @Test
    public void test01() throws IOException {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //ve ekran görüntüsünü alalım
        /*
        -İlk olarak ss aldığımızda nereye kaydetmek istiyorsak oranın yolunu
        belirtelim
        -İkinci olarak TakesScreenShot arayüzünden obje oluşturacağız
        -Üçüncüolarak FileUtils classından copyFile methodu ile ts objemizi
        kullanarak getScreenShotAs methodu iledosya yolunu belirteceğiz
         */
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //ve ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("techproed/ScreenShot/screenShot.png"));
    }

    @Test
    public void test03() throws IOException {
        /*
        Kaydettiğimiz ekran resmi her seferinde aynı dosya üzerine yazmaması için
        dosya isminden sonra String bir değişkene tarih formatı atayabiliriz
         */
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //ve ekran görüntüsünü alalım
        /*
        SimpleDateFormat'ı kullanarak yeni bir tarih formatı oluşturup bir
        String e assing ederiz ve bunu dosya isminden önce belirtiriz.
         */
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));


    }

    @Test
    public void test04() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");


        //ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }
}
