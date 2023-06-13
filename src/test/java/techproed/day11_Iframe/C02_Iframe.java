package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
//==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
//==>  textBox içindeki yazıyı siliniz.
//==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
//==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.


    @Test
    public void iframe() {

        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

//==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
        WebElement kalinYazi=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));

//==>  textBox içindeki yazıyı siliniz.

        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        bekle(2);

        WebElement textBox=driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear();

//==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        WebElement yazi=driver.findElement(By.xpath("//body[@id='tinymce']"));
        yazi.sendKeys("Bu textbox iFrame içinde yer almaktadır");

//==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().parentFrame();

        WebElement elementYazisi=driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(elementYazisi.isDisplayed());

    }
}
