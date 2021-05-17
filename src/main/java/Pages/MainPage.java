package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver lDriver) {
        this.driver = lDriver;
    }

    @FindBy(linkText = "Women")
    WebElement womenButton;
    @FindBy(linkText = "Dresses")
    WebElement dressesButton;
    @FindBy(linkText = "T-shirts")
    WebElement shirtsButton;

    public WebElement getWomenButton() {
        return womenButton;
    }

    public WebElement getDressesButton() {
        return dressesButton;
    }

    public WebElement getShirtsButton() {
        return shirtsButton;
    }

    public void openWomenPage() {
        womenButton.click();
    }

    public void openDressesPage() {
        dressesButton.click();
    }

    public void openShirtsPage() {
        shirtsButton.click();
    }


}
