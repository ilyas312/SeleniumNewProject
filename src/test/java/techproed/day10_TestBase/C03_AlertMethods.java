package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_AlertMethods extends TestBase {


    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("    https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // Bir metod olusturun: acceptAler
        // 1. butona tıklayın,
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        bekle(2);
        // uyarıdaki OK butonuna tıklayın
        //switchTo() geçmek değiştirmek anlamında kullanılıyor
        //accept() çıkan uyarıda "okey" ya da "tamam" butonuna basar
        alertAccept();
        bekle(2);

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
        bekle(2);
        // uyarıdaki Cancel butonuna tıklayın
        alertDismiss();
        bekle(2);
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
        alertPrompt("ilyas");

        //  OK butonuna tıklayın
        alertAccept();

        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actualResult.contains("ilyas"));
    }
}



