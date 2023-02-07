package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddToCartPage {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement cartButton;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement itemLabel;

//    (@FindBy(xpath = "//div[contains(@id,'container')][@class='inventory_container']"))
//    WebElement inventoryContainer;


    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddCartButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'shopping_cart_link')]")));
        addToCartButton.click();



    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void verifyCartItem() {
        Assert.assertEquals(itemLabel.getText(), "Sauce Labs Backpack");
    }
}
