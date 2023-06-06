package techproed.day08_Junit;

import org.junit.*;

public class C02_BeforeClassAfterClass {

    /*
    @BeforeClass class ta en önce çalışan method dur.
    @AfterClass class ta en son çalışan method dur.

    @BeforeClass ve @AfterClass method ları sadece static methodlar ile çalışır.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Classta en önce çalışan methoddur bir kez çalışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Classta en son çalışan methoddur bir kez çalışır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan önce çalışır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra çalışır");
    }

    @Test
    public void test01() {
        System.out.println("İlk test");
    }

    @Test
    public void test02() {
        System.out.println("İkinci test");
    }
}
