package test;

import com.testinium.driver.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LogInPage;
import pages.LogOutPage;
import pages.SearchPage;

public class searchTest extends BaseTest {
    @Test
    public void oyuncakSearch(){

        LogInPage logInPage =new LogInPage();
        SearchPage searchPage =new SearchPage();
        LogOutPage logOutPage=new LogOutPage();


        logInPage.login();


        searchPage.searchProduct();
        searchPage.scrollToElement(By.xpath("(//div[@class='product-list']/div[@class='product-cr'])[7]"));
        String fav1ItemNo = searchPage.addFav(1);
        String fav2ItemNo = searchPage.addFav(2);
        String fav3ItemNo = searchPage.addFav(3);
        String fav4ItemNo = searchPage.addFav(4);
        String[] favItems ={fav1ItemNo,fav2ItemNo,fav3ItemNo,fav4ItemNo};
        searchPage.goToFavs();
        searchPage.favValidation(favItems);
        searchPage.goMainPage();
        searchPage.goToPointCatalogue();
        searchPage.pointCatToTrClassics();



        searchPage.goToHobySection();
        searchPage.addToBasket();


        searchPage.goToFavs();

        searchPage.deleteFromFavs(fav4ItemNo);//debug
        searchPage.deleteFromFavs(fav3ItemNo);
        searchPage.deleteFromFavs(fav2ItemNo);//debug
        searchPage.deleteFromFavs(fav1ItemNo);//debug



        searchPage.basketPage(); // satın al çalışmıyo
        searchPage.newAddress();
        searchPage.buy();

        //hata onay

        searchPage.goMainPage();


        logOutPage.logOut();


    }
}
