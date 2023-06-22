package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_StaleElementReferenceException extends TestBase {
    /*
    STALE_ELEMENT_REFERENCE_EXCEPTION
        Bir web elementin sayfayı refresh(yenileme) ya da back-forward yapma sonucundan
        eskimesi(bayatlaması) durumunda bu exception'ı alırız yani driver sayfayı
        yeniden oluşturduğunda elementin locate'i aynı olmasına rağmen tekrar
        o elementin locateni almamızı ister.Almadığımız takdirde locate'i eskimiş
        olarak görür ve StaleElementReferenceException hatası verir
     */

    @Test
    public void test01() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));

        driver.navigate().refresh();
        /*
        org.openqa.selenium.StaleElementReferenceException hatası aldık çünkü
        refresh yaptıktan sonra tekrar locate almadık dolayısıyla bu hatayı
        handle edebilmek için refresh yaptıktan sonra tekrar locate almalıyız
         */


        aramaKutusu.sendKeys("qa", Keys.ENTER);
        //--> aramaKutusu eskidiği için sendKeys() methodunu kullanamadı


        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test02() {
        /*
        Bu test methodunda test01 methodundaki taleElementReferenceException
        hatasını nasıl handle ettiğimizi gösterdik
         */
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);//--> aramaKutusu eskidigi icin sendKeys() methodunu kullanamadi

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test03() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("developer",Keys.ENTER);

        driver.navigate().back();
        driver.navigate().forward();

        aramaKutusu.sendKeys("qa", Keys.ENTER);//--> aramaKutusu eskidigi icin sendKeys() methodunu kullanamadi
        /*
        org.openqa.selenium.StaleElementReferenceException
         back-forward sonrasinda da hatayi aldik
         */

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));


    }

    @Test
    public void test04() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusunda ıphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone",Keys.ENTER);

        //çıkan sonuclardan ilk 5 ine tıklayıp her ürünün başlığını konsola yazdıralım
        List<WebElement> urunler=driver.findElements(By.xpath("//h2//a"));
        for (int i=0;i<urunler.size();i++){
            urunler.get(i).click();
            bekle(2);
            System.out.println(driver.getTitle());
            driver.navigate().back();
            bekle(2);
            if (i==4){
                break;
            }
           urunler=driver.findElements(By.xpath("//h2//a"));
            //S.E.R.E hatasını handle ettik
        }



    }
}

