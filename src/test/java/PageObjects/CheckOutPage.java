package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement checkOutButton;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName_id;

    @FindBy(xpath = "//input[contains(@id,'last-name')]")
    WebElement lastName_id;

    @FindBy(xpath = "//input[contains(@id,'postal-code')]")
    WebElement postalCode_id;

    @FindBy(xpath = "//input[contains(@id,'continue')]")
    WebElement continueButton;


    public void clickCheckOutButton() {
        checkOutButton.click();
    }

    public CheckOutPage enterFirstName(String firstname) {
        firstName_id.sendKeys(firstname);
        return this;
    }

    public CheckOutPage enterLastName(String lastname) {
        lastName_id.sendKeys(lastname);
        return this;
    }

    public void enterPostalCode(String postalCode)  {
        postalCode_id.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
