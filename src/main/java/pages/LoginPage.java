package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(id = "user-name")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "login-button")
    WebElement btnLogin;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void setTxtUsername(String username) {
        txtUsername.sendKeys(username);
    }


    public void setTxtPassword(String password) {
        txtPassword.sendKeys(password);
    }


    public void setBtnLogin() {
        btnLogin.click();
    }
}
