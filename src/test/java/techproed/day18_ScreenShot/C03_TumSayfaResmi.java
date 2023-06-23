package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_TumSayfaResmi extends TestBase {
    @Test
    public void test01() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //ve ekran görüntüsünü alalım
        tumSayfaResmi();
    }
}
