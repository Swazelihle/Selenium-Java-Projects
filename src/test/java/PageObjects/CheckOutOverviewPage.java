package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckOutOverviewPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='summary_subtotal_label'][contains(.,'Item total: $29.99')]")
    WebElement ItemTotal;
    @FindBy(xpath = "//div[@class='summary_total_label'][contains(.,'Total: $32.39')]")
    WebElement Total_xpath;

    @FindBy(xpath = "//button[contains(@id,'finish')]")
    WebElement FinishButton;

    @FindBy(xpath = "//h2[@class='complete-header'][contains(.,'THANK YOU FOR YOUR ORDER')]")
    WebElement ThankYouForYourOrder_xpath;


    public CheckOutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void calculations() {

    //Resolve Item Total
        String labelItemTotal = ItemTotal.getText();
        System.out.println(labelItemTotal);

        String ItemTotalValue = labelItemTotal.substring(13, 18);
        System.out.println(ItemTotalValue);

        double ItemTotal = Double.parseDouble(ItemTotalValue);
        System.out.println(ItemTotal);

        double GrandItemTax = ItemTotal * 0.08;
        System.out.println(GrandItemTax);

        double GrandTotalBeforeRoundOff = ItemTotal + GrandItemTax;
        System.out.println(GrandTotalBeforeRoundOff);

        double GrandTotal = Math.round(GrandTotalBeforeRoundOff * 100.0) / 100.0;
        System.out.println(GrandTotal);

        //Resolve Total
        String labelTotal = Total_xpath.getText();
        System.out.println(labelTotal);

        String TotalValue = labelTotal.substring(8, 13);
        System.out.println(TotalValue);

        double Total = Double.parseDouble(TotalValue);
        System.out.println(Total);

        Assert.assertEquals(GrandTotal, Total);

    }

    public void clickFinishButton() {
        FinishButton.click();
    }

    public void verifyFinish() {
        Assert.assertEquals(ThankYouForYourOrder_xpath.getText(), "THANK YOU FOR YOUR ORDER");
    }
}

