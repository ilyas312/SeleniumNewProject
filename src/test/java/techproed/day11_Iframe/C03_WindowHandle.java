package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {

    //  https://www.techproeducation.com adresine gidiniz
//  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin

//  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

//  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz

//  techproeducation sayfasına geçiniz
//  youtube sayfasına geçiniz
//  linkedIn sayfasına geçiniz:


    @Test
    public void windowHandle() {

        //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        bekle(3);

        /*
        techproeducation sayfaasının handle değerini getWindowHandle() methodu ile
        elde edebilir
         */

        String techproWindowHandle = driver.getWindowHandle();
        System.out.println("Techpro Handle :" + techproWindowHandle);

//  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
        String actualTitle = driver.getTitle();
        String expentedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expentedTitle, actualTitle);

//  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);//Yeni pencereye driverı taşır
        driver.get("https://www.youtube.com");

        bekle(2);

        String youtubeHandle = driver.getWindowHandle();
        System.out.println("Youtube Handle :" + youtubeHandle);


//  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        bekle(2);

        String linkedHandle = driver.getWindowHandle();
        System.out.println("Linked Handle :" + linkedHandle);

//  techproeducation sayfasına geçiniz
        driver.switchTo().window(techproWindowHandle);
        bekle(2);


//  youtube sayfasına geçiniz
        driver.switchTo().window(youtubeHandle);
        bekle(2);

//  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedHandle);

    }
}
