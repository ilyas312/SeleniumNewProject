package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void test01() {
        //techpro syfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //sayfanın altına doğru gidelim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

        //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();
    }

    @Test
    public void test02() {
        //techpro syfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //sayfanın altına scroll yapalım
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(2);

        //sayfanın üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();
        //build() --> method u actionları birleştirmek için kullanılan methoddur.
        //birden fazla oluşturduğumuz action objesini birbirine bağlar.

        //relase() --> methodu mouse'u bırakır

    }

    @Test
    public void test03() {
        //techpro syfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //sayfanın altına doğru gidelim
        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,1500).perform();

        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-1500).perform();


    }
}
