package com.testinium.methods;


import com.testinium.driver.BaseTest;
import net.bytebuddy.asm.Advice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Stack;


public class Method {

    WebDriver driver;
    FluentWait<WebDriver> wait;

    Logger logger= LogManager.getLogger(Method.class);
    JavascriptExecutor jsdriver;
    public  Method(){
        driver= BaseTest.driver;
        wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }
    public void goLink(String link){
        driver.get(link);

    }

    public WebElement findElement(By by){
        return wait.until((ExpectedConditions.presenceOfElementLocated(by)));
    }
    /**
    public int errorChecker(By by){//span[@class='error']
        var asd = driver.findElements(by);
        return asd.size();

    }**/


    public String favoriteAddScrapper(By by,String attribute){
        String attributeTemp =findElement(by).getAttribute(attribute);
        //logger.info("alınan text:"+ attributeTemp);
        return(attributeTemp.substring(10,16));

    }
    public String displaymodScrapper (By by,String attribute){
        String attributeTemp =findElement(by).getAttribute(attribute);
        //logger.info("alınan text:"+ attributeTemp);
        return attributeTemp;

    }




    /**public List<WebElement> findElements(By by){
        List<WebElement> listOfElements = new List<WebElement>();
        return
    }**/

    public void click(By by){
        findElement(by).click();
    }

    public void waitBySeconds(long seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void sendKeys(By by,String text){
        findElement(by).sendKeys(text);

    }

    public boolean isElementVisible(By by){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            //logger.info("true");
            return true;
        }catch (Exception e){
            //logger.info("false: "+e.getMessage());
            return false;
        }
    }

    public void scrollWithAction(By by){
        Actions actions=new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public void scrollWithJavaS(By by){
        jsdriver.executeScript("argumeys[0]scrollIntoView();",findElement(by));
    }

    public Select getSelect(By by){
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text){
        getSelect(by).selectByVisibleText(text);


    }

    public String getAttribute(By by,String attributeName){

        return  findElement(by).getAttribute(attributeName);
    }

    public String getText(By by){
        return findElement(by).getText();

    }


    public String getValue(By by){
        return jsdriver.executeScript("return arguments[0].value",findElement(by)).toString();
    }

    public void zoomOut(){

        //jsdriver.executeScript("document.body.style.zoom = '0.5'");
    }

    public void clickWithJS(By by){
        jsdriver.executeScript("return arguments[0].click();",findElement(by));
        //
    }
    public void hoverMouse(By by){//çalışmıyo
        WebElement ele =findElement(by);

        Actions action = new Actions(driver);

        action.moveToElement(ele).perform();
    }
    public void hoverClick(By by){
        WebElement subMenu = findElement(by);
        Actions action = new Actions(driver);

        action.moveToElement(subMenu);

        action.click().build().perform();
    }

    public void randItemAddToBasket(){//çalışmıyo
        List<WebElement> listOfElements =  driver.findElements(By.xpath("//div[@class=\"product-cr\"]")); //driver.findElements(By.cssSelector(".add-to-cart"));
        //List<WebElement> listOfElements2 = driver.findElements(By.cssSelector(".mg-b-10>.product-cr"));
        Random rn = new Random();
        int selected = rn.nextInt((listOfElements.size() - 1) + 1) + 1;
        //waitBySeconds(2);

                                          //li[@class="mg-b-10"][1]
        click(By.xpath("//li[@class=\"mg-b-10\"]["+selected+"]"));//çalışmıyo////div[@class="product-cr"]/div[@class="hover-menu"]/a[@class="add-to-cart"]/i
        //click(By.xpath("//li[@class=\"mg-b-10\"]["+selected+"]/div[@class=\"product-cr\"]/div[@class=\"image\"]/div[@class=\"cover\"]/a[1]/img"));//çalışmıyo////div[@class="product-cr"]/div[@class="hover-menu"]/a[@class="add-to-cart"]/i

        click(By.cssSelector(".add-to-cart.btn-orange.btn-ripple"));

    }

    public void dbClick(By by){
        Actions act = new Actions(driver);

        WebElement ele = findElement(by);
        act.doubleClick(ele).perform();
    }


    //public void

}
