package test;

import com.testinium.driver.BaseTest;
import org.junit.Test;
import pages.LogInPage;

public class LogInTest extends BaseTest {
    @Test
    public void loginTest(){
        LogInPage loginPage=new LogInPage();
        loginPage.login();// onay olayını burdan çıkar
    }
}
