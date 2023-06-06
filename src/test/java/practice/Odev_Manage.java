package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev_Manage {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

       // 1.Yeni bir Class olusturalim.C06_ManageWindow
        //2.Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3.Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getSize());

        //4.Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //5.simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //6.Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        driver.manage().window().maximize();

        //7.Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //9.Sayfayi kapatin
        driver.close();

    }
}
