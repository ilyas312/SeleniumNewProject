package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEresmi extends TestBase {
    /*
    Bir webelementin resmini almak için önce webelementi locate edip bir
    web elemente assing ederiz ve bu webelementi direkt getScreenShotAs()
    methodunu kullanarak resmini belirttiğimiz dosyaya kaydederiz.
     */
    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //iphone aratalım
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonuç yazısının resmini alalım
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
}
