package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    //==>   https://testcenter.techproeducation.com/index.php?page=iframe
    //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
    //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
    //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin


    @Test
    public void ifrime() {
        //==>   https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");


        //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        WebElement anIframe = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']"));
        Assert.assertTrue(anIframe.getText().contains("black border"));


        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
        WebElement iframe = driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']"));
        driver.switchTo().frame(iframe);

        /*
        Applications lists yazını doğru locate edip,doğru şekilde görünür olduğunu
        test etmemize rağmen Faild oldu,
        bunun üzerinde HTML kodları inceleyince Applications lists yazısının
        aslında bir iframe içerisinde olduğunu gördük
        bu durumda önce ifram i locate edip
        switchTo() ile ifram e geçmeliyizş
         */

        WebElement aplicationsYazisi=driver.findElement(By.xpath("//h1[@class='display-5 fw-bold']"));
        Assert.assertTrue(aplicationsYazisi.isDisplayed());



        //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
        driver.switchTo().defaultContent();
        /*
        parentFrame()==> Bir üst seviyedeki iframe çıkmak için kullanılır
        defaultContent()==> En üstteki Iframe e çıkmak için kullanılır
         */

       WebElement poveredYazisi=driver.findElement(By.xpath("//p[text()='Povered By']"));
       Assert.assertTrue(poveredYazisi.getText().contains("Povered"));

    }
}
