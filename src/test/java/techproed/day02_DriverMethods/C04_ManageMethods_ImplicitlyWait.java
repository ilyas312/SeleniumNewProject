package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ManageMethods_ImplicitlyWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /*

            implicitlyWait(Duration.ofSeconds(20) sayfadaki webelementleri
        görünür olana kadar (sayfada oluşana kadar) maximum 20 saniye bekler.
        Eğer webelementler 2 saniyede oluşursa 2 saniye bekler ve alt satıra geçer
        Fakat belirttiğimiz maximum süre boyunca internetten ya da sayfadan kaynaklı
        olarak webelementler oluşmazsa testimiz FAIL verir.

            Thread.sleep() java kodlarını bizi belirttiğimiz süre kadar bekler.
        30 saniye bekşlemesini belirtirsem 30 saniye bekler ve alt satıra geçer

         */
        //techpro sayfasına gidelim
        driver.navigate().to("https://techproeducation.com");

        //amazona gidelim
        driver.navigate().to("https://amazon.com");

        //techpro sayfasına geri dönelim
        driver.navigate().back();

        //sayfa başlığının  techpro içerdiğini test edelim
        String actualTitle1=driver.getTitle();
        if (actualTitle1.contains("Techpro")){
            System.out.println("TEST PASSED");
        }else
            System.out.println("TEST FAILED "+ actualTitle1);

        //tekrar amazon sayfasına gidelim
        driver.navigate().forward();

        //sayfa başlığının amazon içerdiğini test edelim
        String actualTitle2=driver.getTitle();
        if (actualTitle2.contains("Amazon")){
            System.out.println("TEST PASSED");
        }else
            System.out.println("TEST FAILED "+ actualTitle2);

        //Sayfayı kapatınız
        driver.close();







    }

}
