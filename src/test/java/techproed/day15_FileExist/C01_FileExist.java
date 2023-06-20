package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {
    @Test
    public void fileExist() {
        System.out.println(System.getProperty("user.dir"));  //C:\Users\İLYAS\SeleniumNewProject
        // bana icinde oldugum projenin dosya yolunu(path) verir.


        System.out.println(System.getProperty("user.home"));  // C:\Users\İLYAS
        // herkesin bilgisayarında farklı olan kısmı verir.


        // SORU:
        // Desktop(masaustu)'da bir text dosyası olusturun


        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        /*
        dosyanın,bilgisayarımda destop'da olup olmadıgını
        Java ile test edecegim.
        cunku selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki desktop'a mudahele edemez
         */

        //"C:\Users\İLYAS\OneDrive\Masaüstü\text.txt"
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\İLYAS\\OneDrive\\Masaüstü\\text.txt")));

        //Daha dinamik hale getirelim

        //"C:\Users\İLYAS      \OneDrive\Masaüstü\text.txt"

        String farkliKisim = System.getProperty("user.home");//herkesin bilgisayarında farklı olan kisim
        String ortakKisim = "\\OneDrive\\Masaüstü\\text.txt";//herkesin bilgisayarında ortak olan kisim

        String dosyaYolu = farkliKisim + ortakKisim;//Dosya yolu olarak farklı kısım ve ortak kısmı aldık

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

}

