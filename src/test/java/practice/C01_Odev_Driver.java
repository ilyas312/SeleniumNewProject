package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Odev_Driver {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //Yeni bir package olusturalim : day01
        //Yeni bir class olusturalim : C03_GetMethods
        //Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://amazon.com");
       // Sayfa basligini(title) yazdirin
        driver.getTitle();
        //Sayfa basliginin “Amazon” icerdigini test edin
       String actualTitle= driver.getTitle();
       String expectedTitle="Amazon";
       if (actualTitle.contains(expectedTitle)){
           System.out.println("Test PASSED");
       }else
           System.out.println("Test FAILED");

        //Sayfa adresini(url) yazdirin
        driver.getCurrentUrl();

        //Sayfa url’inin “amazon” icerdigini test edin.
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="amazon";
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test PASSED");
        }else
            System.out.println("Test FAILED");

        //Sayfa handle degerini yazdirin
        driver.getWindowHandle();

        //Sayfayi kapatin.
        driver.close();

    }
}
