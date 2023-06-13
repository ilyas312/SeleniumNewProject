package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alert extends TestBase {

        /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.


    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.



    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının "successfuly" icermedigini test edin.



    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("    https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

       // Bir metod olusturun: acceptAler
       // 1. butona tıklayın,
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        Thread.sleep(2000);

       // uyarıdaki OK butonuna tıklayın
        //switchTo() geçmek değiştirmek anlamında kullanılıyor
        //accept() çıkan uyarıda "okey" ya da "tamam" butonuna basar
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

       // ve result mesajının "You successfully clicked an alert" oldugunu test edin
       String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
       String expectedResult="You successfully clicked an alert";

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("    https://testcenter.techproeducation.com/index.php?page=javascript-alerts");


        // Bir metod olusturun: dismissAlert
       // 2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);

        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

       // ve result mesajının "successfuly" icermedigini test edin.
       String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
       String expectedResult="successfuly";
       Assert.assertFalse(actualResult.contains(expectedResult));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("    https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // Bir metod olusturun: sendKeysAlert
       // 3. butona tıklayın,
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();

       // uyarıdaki mesajı konsolda yazdırın,
        System.out.println(driver.switchTo().alert().getText());
        //getText() uyarıdaki mesajı bize String olarak getitir


        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("ilyas");

        //  OK butonuna tıklayın
        driver.switchTo().alert().accept();

       // ve result mesajında isminizin görüntülendiğini doğrulayın.
       String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();

       Assert.assertTrue(actualResult.contains("ilyas"));
    }
}
