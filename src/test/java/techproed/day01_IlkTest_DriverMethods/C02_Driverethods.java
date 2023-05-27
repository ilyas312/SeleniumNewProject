package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Driverethods {
    public static void main(String[] args)  {
        System.setProperty("chrome","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://amazon.com");


        //getTitle()Sayfa başlığını verir
        System.out.println("Amazon Sayfa Baslıgı :"+driver.getTitle());
        System.out.println("Amazon Actual Url :"+driver.getCurrentUrl());
        String amazonWindowHandle=driver.getWindowHandle();
        System.out.println("Amazon Window Handle Degeri :"+amazonWindowHandle);


        driver.get("https://techproeducation.com");
        System.out.println("Techproeducation Sayfa Baslıgı :" +driver.getTitle());
        //getTitle() method u Sayfa başlığının adını verir

        //getCurrentUrl() gidilen sayfanın url sini verir
        System.out.println("Techproed Actual Url :"+driver.getCurrentUrl());


        //getPageSource() Acilan sayfanin kaynak kodlarını String olarak getirir
        //System.out.println(driver.getPageSource()); bilelerek yoruma aldık her çalıştırdığımızda bütün kaynak kodları vereceği icin

        //getWindowHandle() gidilen sayfanın handle degerini(hashKod) verir.
        // Bu handle degerini sayfalar arası geciş icin kullanırız
        System.out.println("Techpro Window Handle Degeri :"+driver.getWindowHandle());

    }
}
