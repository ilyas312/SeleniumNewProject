package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    //Techproeducation sayfasına gidiniz
    //Başlığın "Bootcamp" içeridiğini test ediniz


    @Test
    public void test01() {

        //Techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");

        //Başlığın "Bootcamp" içeridiğini test ediniz
        String actualTitle=driver.getTitle();
        String expectedTitle="Bootcamp";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
