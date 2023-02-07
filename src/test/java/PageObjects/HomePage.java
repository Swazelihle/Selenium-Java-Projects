package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    WebElement productLabel_xpath;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void
    verifyLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(.,'Products')]")));
        Assert.assertEquals(productLabel_xpath.getText(), "PRODUCTS");
    }
}

