package Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SauceDemoTests extends BaseTests {
    @Test
    public void InvalidDetails() {
        takeScreenshot.takeSnapShot(driver, "loginScreen");
        loginPage
                //ToDo The below inputs will be read from data sheet(To be done)
                .enterUsername("test")
                .enterPassword("test")
                .clickLoginButton()
                .verifyInvalidDetails();
    }

    @Test(dependsOnMethods = "InvalidDetails")
    public void login() {
        takeScreenshot.takeSnapShot(driver, "loginScreen");
        loginPage
                //ToDo The below inputs will be read from data sheet(To be done)
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton();
    }

    @Test(dependsOnMethods = "login")
    public void verifyLoginSuccess() {
        homePage
                .verifyLoginSuccess();
    }

    @Test(dependsOnMethods = "verifyLoginSuccess")
    public void addToCart() {
        addToCartPage
                .clickAddCartButton();
    }

    @Test(dependsOnMethods = "addToCart")
    public void CartButton() {
        addToCartPage
                .clickCartButton();
    }

    @Test(dependsOnMethods = "CartButton")
    public void verifyCartItem() {
        takeScreenshot.takeSnapShot(driver, "CartScreen");
        addToCartPage
                .verifyCartItem();
    }

    @Test(dependsOnMethods = "verifyCartItem")
    public void checkout() {
        checkOutPage
                .clickCheckOutButton();
    }

    @Test(dependsOnMethods = "checkout")
    public void enterDetails() {
        //ToDo The below inputs will be read from data sheet(To be done)
        checkOutPage
                .enterFirstName("Lilitha")
                .enterLastName("Dlodlo")
                .enterPostalCode("2194");
    }

    @Test(dependsOnMethods = "enterDetails")
    public void continueButton() {
        checkOutPage
                .clickContinueButton();
    }

    @Test(dependsOnMethods = "continueButton")
    public void checkOutOverview() {
        checkOutOverviewPage
                .calculations();
    }

    @Test(dependsOnMethods = "checkOutOverview")
    public void clickFinish() {
        checkOutOverviewPage
                .clickFinishButton();
    }

    @Test(dependsOnMethods = "clickFinish")
    public void VerifyFinish() {
        takeScreenshot.takeSnapShot(driver, "FinishScreen");
        checkOutOverviewPage
                .verifyFinish();
    }

    @Test(dependsOnMethods = "VerifyFinish")
    public void clickBurgerMenu() {
        checkOutCompletePage
                .clickBurgerMenuButton();
    }

    @Test(dependsOnMethods = "clickBurgerMenu")
    public void clickLogOut() {
        takeScreenshot.takeSnapShot(driver, "LogOutScreen");
        checkOutCompletePage
                .clickLogOutButton();
    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }

}

