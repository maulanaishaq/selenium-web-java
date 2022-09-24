package pages;


import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage extends TestBase {

    @FindBy(id = "cancel")
    WebElement btnCancel;

    @FindBy(id = "continue")
    WebElement btnContinue;

    @FindBy(id = "first-name")
    WebElement txtFirstName;

    @FindBy(id = "last-name")
    WebElement txtLastName;

    @FindBy(id = "postal-code")
    WebElement txtPostalCode;


    public CheckoutInformationPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickBtnCancel(){
        btnCancel.click();
    }

    public void clickBtnContinue(){
        btnContinue.click();
    }

    public void inputFirstName(String firstname){
        txtFirstName.sendKeys(firstname);
    }

    public void inputLastName(String lastname){
        txtLastName.sendKeys(lastname);
    }


    public void inputPostalCode(String postalCode){
        txtPostalCode.sendKeys(postalCode);
    }



}
