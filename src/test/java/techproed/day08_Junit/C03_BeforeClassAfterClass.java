package techproed.day08_Junit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class C03_BeforeClassAfterClass {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon Testi Baslatıldı");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Testi Sonuclandı");
    }

    @Before
    public void setUp() throws Exception {

    }
}
