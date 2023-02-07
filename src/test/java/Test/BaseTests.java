package Test;

import PageObjects.*;
import Utils.BrowserFactory;
import Utils.TakeScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTests {

    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("Chrome", "https://www.saucedemo.com/");

    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    AddToCartPage addToCartPage = PageFactory.initElements(driver, AddToCartPage.class);

    CheckOutPage checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);

    CheckOutOverviewPage checkOutOverviewPage = PageFactory.initElements(driver, CheckOutOverviewPage.class);

    CheckOutCompletePage checkOutCompletePage = PageFactory.initElements(driver, CheckOutCompletePage.class);

    TakeScreenshot takeScreenshot = new TakeScreenshot();
}
