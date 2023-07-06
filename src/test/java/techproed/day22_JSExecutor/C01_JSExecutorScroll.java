package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutorScroll extends TestBase {

    /*
    Actions class ındaki gibi js executor ile de sayfada scroll işlemi yapılabiliriz
    Bir webelementi locate edip o webelement görünür olana kadar scroll
    yapabiliriz.
    "arguments[0].scrollIntoView(true);", Webelement--> Bu script kodu ile belirtilmiş
    olduğumuz webelemente scroll yapabiliriz
     */

    @Test
    public void test01() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et
        // ve ekran görüntüsünü al
        WebElement weofferWE = driver.findElement(By.xpath("//*[.='we offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", weofferWE);
        tumSayfaResmi();

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et
        // ve ekran görüntüsünü al
        WebElement enrollFreeWE = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFreeWE);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et
        // ve ekran görüntüsünü al
        WebElement whyUsWE = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        js.executeScript("arguments[0].scrollIntoView(true);", whyUsWE);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et
        // ve ekran görüntüsünü al
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFreeWE);
        bekle(2);
        tumSayfaResmi();

        //Sayfayı en alta scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //Sayfayi en üste scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,2000)");//-->x=0,y=2000 pixel olarak bir noktaya scroll yapar

    }

    @Test
    public void test03() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et
        // ve ekran görüntüsünü al
        WebElement weofferWE = driver.findElement(By.xpath("//*[.='we offer']"));
        jsScrollWE(weofferWE);

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et
        // ve ekran görüntüsünü al
        WebElement enrollFreeWE = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jsScrollWE(enrollFreeWE);

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et
        // ve ekran görüntüsünü al
        WebElement whyUsWE = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        jsScrollWE(whyUsWE);

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et
        // ve ekran görüntüsünü al
        jsScrollWE(enrollFreeWE);

        //Sayfayı en alta scroll yapalım
        scrollEnd();

        //Sayfayi en üste scroll yapalım
        scrollHome();
    }
}
