package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void test01() {
        /*
        NO_SUCH_ELEMENT_EXCEPTION
            -Bir web elementin locate'ini yanlış aldığımızda,elementi bulumayacağı
             için bu exception ı alırız.
         */

        //techproeducation sayfasına gidelim
        //arama kutusunda qa aratalım

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //arama kutusunda qa aratalım
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);

       /*normal locatemiz //*[@type='search'] bu sekilde iken
        NoSuchElementException alabilmek icin locate'i bozduk

        //*[@type='ssearch'] ve exception'i aldigimizi gorduk. Dolayisiyla bu hatayi handle edebilmek icin
        duzgun locate almamiz gerekiyor

        */


        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım

       WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));

       aramaKutusu.sendKeys("qa",Keys.ENTER);
       /*
        org.openqa.selenium.InvalidSelectorException: xpath ile aldigimiz bir webelementin locate'ini
        cssSelector locator ile kullanirsak bu exception'i aliriz
        Dolayısıyla bunu handle etmek için doğru locator kullanmamız gerekir.
        Web element bir iframe içinde olabilir,bir butona tıkladığımızda yeni bir
        pencere açılabilir yada alert çıkabilir bu gibi durumlarda da
        nosuchelementexception alırız
         */

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));


    }
}
