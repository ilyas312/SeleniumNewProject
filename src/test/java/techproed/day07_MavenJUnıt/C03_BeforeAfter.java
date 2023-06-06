package techproed.day07_MavenJUnıt;

import org.junit.*;

public class C03_BeforeAfter {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test1() {

    }

    @Test
    public void test2() {

    }

    @After
    public void tearDown() throws Exception {

    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her classtan önce 1 kez çalışır");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her classtan sonra 1 kez çalışır");

    }
}
