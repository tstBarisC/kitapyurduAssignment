package pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogInPage {
    Method method;
    Logger logger = LogManager.getLogger(LogInPage.class);
    public LogInPage(){
        method=new Method();
    }

    public void  login(){
        method.zoomOut();
        method.click(By.cssSelector(".menu-top-button.login>a"));
        method.sendKeys(By.cssSelector("#login-email"),"yiboc21134@randrai.com");
        method.sendKeys(By.xpath("//input[@id='login-password']"),"1q2w3e4r5t");    //(By.cssSelector("#login-password"),"nese.aydin@testinium.com");
        method.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        if(method.isElementVisible(By.cssSelector(".common-sprite>b")))
            logger.info("Login: success");
    }
}