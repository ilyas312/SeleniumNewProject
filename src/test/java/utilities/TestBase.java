package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    /*
    Bu class a extends ettiğimiz test classlarından ulaşabiliriz
    Testbase classından obje oluşturulmasının önüne geçilmesi için "abstract"
    yapılabilir
     */

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws Exception {

        //driver.quit();

    }

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void alertAccept() {
        driver.switchTo().alert().accept();
    }

    public void alertDismiss() {

        driver.switchTo().alert().dismiss();
    }

    public void alertPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    public void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);

    }
    public void Value(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);

    }
}
