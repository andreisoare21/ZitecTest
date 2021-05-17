package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenPage {

    WebDriver driver;

    public WomenPage(WebDriver lDriver) {
        this.driver = lDriver;
    }

    @FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
    WebElement firstProduct;

    public WebElement getFirstProduct() {
        return firstProduct;
    }

    public void openFirstProduct() {
        firstProduct.click();
    }

}
