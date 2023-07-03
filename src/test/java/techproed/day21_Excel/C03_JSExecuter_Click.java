package techproed.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_Click extends TestBase {

    /*
Eger bir web sayfasının HTML kodları tamamen yada kısmen JavaScript kullanılarak olusturulduysa,
o sayfayla etkilesimde bulunmak icin standart WebDriver komutları yetersiz kalabilir.


Bu durumda sayfayla etkilesime gecebilmek icin JavaScriptExecuter arayuzunu kullanmak gerekir.
JavaScriptExecuter arayuzu sayfaya dogrudan erisebilir.

Ancak, mümkünse WebDriver'ın sundugu standart yöntemlerle sayfayla etkilesime gecmek her zaman daha iyidir.
Cünkü JS kullanımı sayfanın daha yavas yuklenmesine neden olabilir.


 */

    @Test
    public void jsExecuterClick() {

        //https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        //returns kısmına tıklayın
       WebElement returns=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
      // returns.click();

       /*
       İlgili webelementin HTML kodu JavaScript kullanılarak oluşturulduysa
       standart WebDriver komutu olan click() yetersiz kalabilir.
       Böyle durumlarda JavaScriptExecuter kullanılarak sayfayla etkileşime
       geçilebilir.
        */

       click(returns);


    }
}
