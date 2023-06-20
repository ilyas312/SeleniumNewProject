package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ExplicitWait extends TestBase {

    @Test
    public void test01() {

        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //==>  Remove tuşuna basın
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //==>  "It's gone!" yazısının görünür oldugunu test edin.

        WebElement goneYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(goneYazisi.isDisplayed());
        //visibleWait(goneYazisi,15);

    }
}
