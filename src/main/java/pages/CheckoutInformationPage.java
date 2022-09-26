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

    @FindBy(xpath = "//h3[starts-with(text(), 'Error: First Name is required')]")
    WebElement errorTxtFirstname;

    @FindBy(xpath = "//h3[starts-with(text(), 'Error: Last Name is required')]")
    WebElement errorTxtLastname;

    @FindBy(xpath = "//h3[starts-with(text(), 'Error: Postal Code is required')]")
    WebElement errorTxtPostalCode;



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


    public String getTextErrorFirstname(){
        String firstname = errorTxtFirstname.getText();
        return firstname;
    }

    public String getTextErrorLastname(){
        String lastname = errorTxtLastname.getText();
        return lastname;
    }

    public String getTextErrorPostalCode(){
        String postalcode = errorTxtPostalCode.getText();
        return postalcode;
    }


}
