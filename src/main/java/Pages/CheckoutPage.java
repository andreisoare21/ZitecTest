package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver lDriver) {
        this.driver = lDriver;
    }

    @FindBy(css = "body.order.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 p.cart_navigation.clearfix:nth-child(7) a.button.btn.btn-default.standard-checkout.button-medium > span:nth-child(1)")
    WebElement proceedToCheckout;

    @FindBy(css = "#email_create")
    WebElement emailField;

    @FindBy(css = "body.authentication.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 div.row div.col-xs-12.col-sm-6:nth-child(1) form.box div.form_content.clearfix div.submit:nth-child(4) button.btn.btn-default.button.button-medium.exclusive:nth-child(2) > span:nth-child(1)")
    WebElement createAccount;

    @FindBy(css = "#id_gender1")
    WebElement selectGender;

    @FindBy(css = "#customer_firstname")
    WebElement customerFirstName;

    @FindBy(css = "#customer_lastname")
    WebElement customerLastName;

    @FindBy(css = "#passwd")
    WebElement customerPassword;

    @FindBy(css = "#firstname")
    WebElement deliveryFirstName;

    @FindBy(css = "#lastname")
    WebElement deliveryLastName;

    @FindBy(css = "#address1")
    WebElement deliveryAddress;

    @FindBy(css = "#city")
    WebElement deliveryCity;

    @FindBy(css = "#id_state")
    WebElement deliveryState;

    @FindBy(css = "#postcode")
    WebElement deliveryZip;

    @FindBy(css = "#phone_mobile")
    WebElement mobilePhone;

    @FindBy(css = "body.authentication.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 form.std.box div.submit.clearfix:nth-child(4) button.btn.btn-default.button.button-medium:nth-child(4) > span:nth-child(1)")
    WebElement registerButton;

    @FindBy(css = "body.order.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 form:nth-child(3) p.cart_navigation.clearfix button.button.btn.btn-default.button-medium:nth-child(4) > span:nth-child(1)")
    WebElement advanceToShipping;

    @FindBy(css = "#cgv")
    WebElement acceptTerms;

    @FindBy(css = "body.order.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 div:nth-child(1) form:nth-child(3) p.cart_navigation.clearfix button.button.btn.btn-default.standard-checkout.button-medium:nth-child(4) > span:nth-child(1)")
    WebElement advanceToPayment;

    @FindBy(css = "body.order.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 div.paiement_block div:nth-child(3) div.row:nth-child(1) div.col-xs-12.col-md-6 p.payment_module > a.bankwire")
    WebElement selectPaymentMethod;

    @FindBy(css = "body.module-bankwire-payment.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 form:nth-child(3) p.cart_navigation.clearfix button.button.btn.btn-default.button-medium > span:nth-child(1)")
    WebElement confirmOrder;

    @FindBy(css = "body.order-confirmation.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 div.box p.cheque-indent:nth-child(1) > strong.dark")
    WebElement orderConfirmation;

    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }

    public void setCreateAccount(String email) {
        emailField.sendKeys(email);
        createAccount.click();
    }

    public void fillPersonalInfo(String firstName, String lastName, String password) {
        selectGender.click();
        customerFirstName.sendKeys(firstName);
        customerLastName.sendKeys(lastName);
        customerPassword.sendKeys(password);
    }


    public void fillPersonalInfo(String address, String city,int stateIndex, String zip, String phone) {
        deliveryAddress.sendKeys(address);
        deliveryCity.sendKeys(city);
        deliveryState.click();
        deliveryState.sendKeys(Keys.ARROW_DOWN);
        deliveryState.sendKeys(Keys.RETURN);
        deliveryZip.sendKeys(zip);
        mobilePhone.sendKeys(phone);
        registerButton.click();
    }


    public void setAdvanceToShipping() {
        advanceToShipping.click();
    }

    public void setAcceptTerms() {
        acceptTerms.click();
    }

    public void setAdvanceToPayment(){
        advanceToPayment.click();
    }

    public void setSelectPaymentMethod() {
        selectPaymentMethod.click();
    }

    public void setConfirmOrder() {
        confirmOrder.click();
    }

    public String verifyPlaceOrder(){
        String successMessage = orderConfirmation.getText();
        return successMessage;
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getCreateAccount() {
        return createAccount;
    }

    public WebElement getSelectGender() {
        return selectGender;
    }

    public WebElement getCustomerFirstName() {
        return customerFirstName;
    }

    public WebElement getCustomerLastName() {
        return customerLastName;
    }

    public WebElement getCustomerPassword() {
        return customerPassword;
    }

    public WebElement getDeliveryFirstName() {
        return deliveryFirstName;
    }

    public WebElement getDeliveryLastName() {
        return deliveryLastName;
    }

    public WebElement getDeliveryAddress() {
        return deliveryAddress;
    }

    public WebElement getDeliveryCity() {
        return deliveryCity;
    }

    public WebElement getDeliveryState() {
        return deliveryState;
    }

    public WebElement getDeliveryZip() {
        return deliveryZip;
    }

    public WebElement getMobilePhone() {
        return mobilePhone;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getAdvanceToShipping() {
        return advanceToShipping;
    }

    public WebElement getAcceptTerms() {
        return acceptTerms;
    }

    public WebElement getAdvanceToPayment() {
        return advanceToPayment;
    }

    public WebElement getSelectPaymentMethod() {
        return selectPaymentMethod;
    }

    public WebElement getConfirmOrder() {
        return confirmOrder;
    }

    public WebElement getOrderConfirmation() {
        return orderConfirmation;
    }
}
