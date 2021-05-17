package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver lDriver) {
        this.driver = lDriver;
    }

    @FindBy(xpath = "//iframe[starts-with(@id,'fancybox-frame')]")
    WebElement productIframe;

    @FindBy(css = "body.product.product-1.product-faded-short-sleeve-tshirts.category-3.category-women.hide-left-column.hide-right-column.content_only.lang_en:nth-child(2) div.primary_block.row div.pb-right-column.col-xs-12.col-sm-4.col-md-3 div.box-info-product div.product_attributes.clearfix p:nth-child(1) a.btn.btn-default.button-plus.product_quantity_up:nth-child(4) > span:nth-child(1)")
    WebElement increaseQuantity;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement addToCart;

    @FindBy(css = "body.category.category-3.category-women.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div.clearfix div.layer_cart_cart.col-xs-12.col-md-6 div.button-container:nth-child(5) span.continue.btn.btn-default.button.exclusive-medium > span:nth-child(1)")
    WebElement continueShopping;

    @FindBy(css = "body.category.category-3.category-women.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div.clearfix div.layer_cart_cart.col-xs-12.col-md-6 div.button-container:nth-child(5) a.btn.btn-default.button.button-medium > span:nth-child(1)")
    WebElement proceedToCheckout;

    @FindBy(css = "body.category.category-3.category-women.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div:nth-child(4) div.clearfix div.layer_cart_cart.col-xs-12.col-md-6 h2:nth-child(1) > span.ajax_cart_product_txt_s")
    WebElement successMessage;

    @FindBy(css = "#our_price_display")
    WebElement price;

    @FindBy(css = "body.category.category-3.category-women.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div:nth-child(4) div.clearfix div.layer_cart_cart.col-xs-12.col-md-6 div.layer_cart_row:nth-child(2) > span.ajax_block_products_total")
    WebElement totalPrice;

    public void switchToIframe() {
        driver.switchTo().frame(productIframe);
    }

    public void setIncreaseQuantity() {
        increaseQuantity.click();
    }

    public void setAddToCart() {
        addToCart.click();
    }

    public void setContinueShopping() {
        continueShopping.click();
    }

    public void setProceedToCheckout() {
        proceedToCheckout.click();
    }

    public String getSuccessMessage() {
        WebDriverWait driverWait = new WebDriverWait(driver, 30);
        driverWait.until(ExpectedConditions.visibilityOf(successMessage));
        driver.switchTo().defaultContent();

        String successMsg = successMessage.getText();
        return successMsg;
    }

    public float getProductPrice() {
        String productPrice = price.getText();

        productPrice = productPrice.substring(1);
        float floatPrice = Float.parseFloat(productPrice);
        return floatPrice;
    }

    public float getTotalProductsPrice() {
        String productsTotalPrice = totalPrice.getText();
        productsTotalPrice = productsTotalPrice.substring(1);
        float totalPrice = Float.parseFloat(productsTotalPrice);

        return totalPrice;
    }

    public WebElement getProductIframe() {
        return productIframe;
    }

    public WebElement getIncreaseQuantity() {
        return increaseQuantity;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getContinueShopping() {
        return continueShopping;
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }
}
