package pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class LogOutPage {
    Method method;
    Logger logger= LogManager.getLogger(LogOutPage.class);
    public LogOutPage(){
        method=new Method();
    }

    public void logOut(){
        method.hoverMouse(By.xpath("//div[@class=\"menu top login\"]"));
        method.click(By.xpath("//a[text()='Çıkış']"));
        method.waitBySeconds(5);
    }
}
