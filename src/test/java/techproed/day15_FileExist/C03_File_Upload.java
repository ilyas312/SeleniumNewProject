package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;

public class C03_File_Upload extends TestBase {

    // masaustunde bir deneme dosyası olusturun
    // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
    // 'Upload' butonuna basın
    // 'File Uploaded!' yazısının goruntulendigini test edin


    @Test
    public void name() {
        // masaustunde bir deneme dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec=driver.findElement(By.xpath("//input[@id='file-upload']"));
       String farkli=System.getProperty("user.home");
       String ortak="\\OneDrive\\Masaüstü\\deneme.txt";

       String deneme=farkli+ortak;

       dosyaSec.sendKeys(deneme);

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();


        // 'File Uploaded!' yazısının goruntulendigini test edin
       WebElement uploaded=driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(uploaded.isDisplayed());
    }
}
