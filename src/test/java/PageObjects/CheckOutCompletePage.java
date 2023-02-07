package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutCompletePage {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(@id,'react-burger-menu-btn')]")
    WebElement BurgerMenu;

    @FindBy(xpath = "//a[contains(@id,'link')][@class='bm-item menu-item'][contains(.,'Logout')]")
    WebElement logOutButton_xpath;


    public CheckOutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBurgerMenuButton() {
        BurgerMenu.click();
    }

    public void clickLogOutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@id,'link')][@class='bm-item menu-item'][contains(.,'Logout')]")));
        logOutButton_xpath.click();
    }

}
