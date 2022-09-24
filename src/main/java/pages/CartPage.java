package pages;


import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends TestBase {

    @FindBy(id = "continue-shopping")
    WebElement btnContinueShoping;

    @FindBy(id = "checkout")
    WebElement btnCheckout;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement btnRemoveProduct1;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement btnRemoveProduct2;


    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement btnCart;

    public CartPage(){
        PageFactory.initElements(driver, this);
    }


    public void clickBtnShoping(){
        btnContinueShoping.click();
    }

    public void clickBtnCheckout(){
        btnCheckout.click();
    }

    public void clickBtnRemoveProduct1(){
        btnRemoveProduct1.click();
    }

    public void clickBtnRemoveProduct2(){
        btnRemoveProduct2.click();
    }

    public void clickBtnCart(){
        btnCart.click();
    }


}
