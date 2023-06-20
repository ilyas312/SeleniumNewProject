package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

    /*
    Implictly Wait ==> Sayfadaki tüm webelementlerin yüklenebilmesi için max.
                       bekleme süresi

    Explict Wait ==> Belirli bir koşul gerçekleşene kadar max. süre boyunca
                       default olarak 500 mili saniye aralıklarla webelementi
                       kontrol ederek bekler.
                       (sadece belirli bir webelement için kullanılır)
     */

    @Test
    public void explicitWait() {
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Start']")).click();


        //==> Hello World! yazısının görünürlügünü test edin

        /*
        WebElement hello=driver.findElement(By.xpath("//*[text()='Hello World!']"));
        Assert.assertTrue(hello.isDisplayed());

        Hello World! yazısının görünürlüğünü imlicitly wait ile çözemedik
         */

        WebElement hello=driver.findElement(By.xpath("//*[text()='Hello World!']"));

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOf(hello));

        Assert.assertTrue(hello.isDisplayed());


    }
}
