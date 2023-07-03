package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan class
    protected ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTML formatında düzenler
    protected ExtentTest extentTest;//--> Test adınlarına eklemek istediğimiz bilgileri bu class ile oluştururuz


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
        extentReports=new ExtentReports();
        extentReports.flush();
      //  driver.quit();

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

    //getTextAlert
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    //sendKeysAlert
    public void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
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

    public void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void switchToWindow(int index) {
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }

    public void switchWindow(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());


    }

    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text) {
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //Tüm sayfa resmi(ScreenShot)
    public void tumSayfaResmi() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElement resmi(WebElement ScreenShot)
    public void webElementResmi(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //UploadFile Robot Class
    public void uploadFilePath(String filePath) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    //Extent Report Methodu
    public void extentReport(String browser, String reportName) {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//-->HTML formatında raporlamayı başlatacak

        //Raporda gözükmesini isteğimiz bilgiler için
        extentReports.setSystemInfo("Browser", browser);
        extentReports.setSystemInfo("Tester", "Ilyas");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName(reportName);


    }

    public void click(WebElement element){
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
        }
    }

}