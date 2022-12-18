package pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchPage {
    Method method;
    Logger logger= LogManager.getLogger(SearchPage.class);

    public SearchPage(){
        method=new Method();
    }
    public void searchProduct(){
        //method.waitBySeconds(20);

        method.sendKeys(By.xpath("//input[@id='search-input']"),"oyuncak");
        method.click(By.cssSelector(".common-sprite.button-search"));
        logger.info("Search: oyuncak");
    }

    public void scrollToElement(By by){
        method.scrollWithAction(by);
        logger.info("Scroll: 7.th product");
    }
    public String addFav(int productOrder){
        String fevItemNo= method.favoriteAddScrapper(By.cssSelector(".product-list>.product-cr:nth-child("+Integer.toString(productOrder)+")>.grid_2.alpha.omega.relative>.hover-menu>.add-to-cart"),"onclick");
        method.click(By.cssSelector( ".product-list>.product-cr:nth-child("+Integer.toString(productOrder)+")>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"));
        logger.info("Fav product ID: "+fevItemNo);
        return fevItemNo;
    }


    public void goToFavs(){
        method.waitBySeconds(1);
        method.hoverMouse(By.xpath("//a[text()='Listelerim']"));
        method.click(By.xpath("//a[text()='Favorilerim']"));
        logger.info("Page open: Favorites");

    }

    public void goMainPage(){
        method.goLink("https://www.kitapyurdu.com/");
        logger.info("Page open: Main Page");

    }
    public void goToPointCatalogue(){
        method.click(By.cssSelector(".lvl1catalog>.common-sprite"));


    }
    public void pointCatToTrClassics() {
        method.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        logger.info("Page open: Turkish classics");

        method.selectByText(By.xpath("//select[@onchange='location = this.value;']"), "Yüksek Oylama");
        logger.info("Sorting: Yüksek Oylama");

    }
    public void changeBasket(){
        method.sendKeys(By.xpath("//input[@name='quantity']"),"3");
        }


    public  void test(){

    }
    public void goToHobySection(){
        method.hoverMouse(By.xpath("//*[@id='mainNav']/div[1]/ul/li[1]/div[2]/ul/li[3]/span"));
        //method.click(By.xpath("//*[@id='mainNav']/div[1]/ul/li[1]/div[2]/ul/li[3]/span"));
        //method.hoverClick(By.xpath("//a[@href='kategori/kitap-hobi/1_212.html']"));
        method.waitBySeconds(1);
        method.click(By.xpath("//a[text()='Hobi']"));
        logger.info("Page open: Hobby Books");
        //method.waitBySeconds(3);


    }
    public void addToBasket(){
        method.randItemAddToBasket();
        logger.info("Add Basket: Random Product");


    }


    public void favValidation(String[] newfavs){
        String NuberOfFavvedItem = method.findElement(By.xpath("//span[@class='favorite-tag active']/span")).getText();
        String[] favvedItems= new String[Integer.parseInt(NuberOfFavvedItem)];

        String displayModForFavs= method.displaymodScrapper(By.xpath("//div[@class='display']/a[1]"),"onclick");
        if(displayModForFavs.equals("display('list');")){
            method.click(By.xpath("//span[@class='sprite sprite-icon-list']"));
        }
        method.click(By.xpath("//span[@class='display-item sprite sprite-icon-list-selected']"));
        for (int favvedCounter=0;favvedCounter<Integer.parseInt(NuberOfFavvedItem);favvedCounter++){
            String fevItemNo= method.favoriteAddScrapper(By.xpath("//div[@class='product-list']/div["+Integer.toString(favvedCounter+1)+"]/div[2]/div[3]/a[@class='add-to-cart']"),"onclick");  //"//a[@class='add-to-cart']"
            favvedItems[favvedCounter]=fevItemNo;
        }
        List<String> listOfAllFavs = new ArrayList<>(Arrays.asList(favvedItems));

        for (int counter=0;counter<newfavs.length;counter++){
            //String fevItemNo= method.favoriteAddScrapper(By.cssSelector("//a[@class='add-to-cart']"),"onclick");
            if(listOfAllFavs.contains(newfavs[counter])){
                System.out.println(newfavs[counter]+" is in the favs");
            }
            else {
                System.out.println(newfavs[counter]+" is not in the favs");

            }
        }
    }

    public void deleteFromFavs(String favItemNo){
        method.waitBySeconds(2);
        method.click(By.xpath("//div[@class='hover-menu']/a[@onclick='removeFromFavorites("+favItemNo+");']"));
        logger.info("Deleted item from favorites: "+favItemNo);



    }


    public void basketPage(){
        method.goLink("https://www.kitapyurdu.com/index.php?route=checkout/cart");
        logger.info("Page open: Basket");


        method.dbClick(By.xpath("//input[@name='quantity']"));
        method.sendKeys(By.xpath("//input[@name='quantity']"),"5");


        method.click(By.xpath("//i[@title='Güncelle']"));
        logger.info("Changed Product Quantity: Hobby Books");

        //var asdasd1 =method.isElementVisible(By.cssSelector(".button.red"));

        method.waitBySeconds(1);//miktar yerinin değiştiğini onayla yada fiyatı
        //method.click(By.xpath("//a[@class='button red']"));
        //var asdasd2 =method.isElementVisible(By.cssSelector(".button.red"));
        method.click(By.cssSelector(".right>.button.red"));
        method.waitBySeconds(2);
        logger.info("Buy");

    }

    public void newAddress(){
        method.click(By.xpath("//a[@onclick=\"setShippigAddressType('new')\"]"));
        logger.info("Page open: New Address");

        method.sendKeys(By.xpath("//input[@id=\"address-firstname-companyname\"]"),"Test");
        method.sendKeys(By.xpath("//input[@id=\"address-lastname-title\"]"),"inium");
        method.selectByText(By.xpath("//select[@id=\"address-zone-id\"]"),"İstanbul");
        method.waitBySeconds(1);
        method.selectByText(By.xpath("//select[@id=\"address-county-id\"]"),"ADALAR");
        method.waitBySeconds(1);
        method.sendKeys(By.xpath("//textarea[@id=\"address-address-text\"]"),"Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        method.sendKeys(By.xpath("//input[@id=\"address-mobile-telephone\"]"),"5555555555");
        method.click(By.xpath("//button[@type='button']"));
        logger.info("Address created");

        method.waitBySeconds(3);
    }
    public void buy(){
        method.click(By.xpath("//button[@id='button-checkout-continue']"));
        method.sendKeys(By.xpath("//input[@id='credit-card-owner']"),"Test İnium");
        method.sendKeys(By.xpath("//input[@name='credit_card_number_1']"),"5555555555555555");
        method.selectByText(By.xpath("//select[@id='credit-card-expire-date-month']"),"01");
        method.waitBySeconds(1);

        method.selectByText(By.xpath("//select[@id='credit-card-expire-date-year']"),"2024");
        method.waitBySeconds(1);

        method.sendKeys(By.xpath("//input[@id='credit-card-security-code']"),"555");
        method.click(By.xpath("//button[@id='button-checkout-continue']"));
        logger.info("Is card valid: Hobby Books"+method.isElementVisible(By.xpath("//span[@class='error']")));


    }



}
