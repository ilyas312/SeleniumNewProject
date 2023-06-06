package techproed.day07_MavenJUnıt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_junitIlkTest {
      /*
            Notasyonlara sahip methodlar oluşturabilmek için
            mouse+sağ tik+generate(alt+insert)
            yaparak after method için teardown u seçeriz
            before method için setup ı seçeriz.
            test methodu için de test i seçeriz.
                JUnit frameworkunde testlerimizi siralama yapabilmek icin
            ekstra bir notasyon yoktur.Eger belli bir siralamada calistirmak
            istersek method isimlerini alfabetik ve sayisal olarak belirtmemiz
            gerekir

         */

    @After
    public void tearDown() {
        System.out.println("Her test methodundan sonra bir kez çalışır");
    }

    @Before
    public void setUp() {
        System.out.println("Her test methodundan önce bir kez çalışır");
    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu çalıştı");
    }

    @Test
    public void test2() {
        System.out.println("Test2 methodu çalıştı");
    }

    @Test
    public void test3() {
        System.out.println("Test3 methodu çalıştı");
    }
}
