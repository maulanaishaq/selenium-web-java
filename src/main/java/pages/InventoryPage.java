package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends TestBase {


    String urlInventoyPage = "https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//span[@class='title']")
    WebElement title;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement btnCart;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement btnDropdownListSort;

    @FindBy(xpath = "//div[starts-with(text(), 'Sauce Labs Backpack')]")
    WebElement txtProductName1;

    @FindBy(xpath = "//div[starts-with(text(),'Sauce Labs Bike Light')]")
    WebElement txtProductName2;


    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement btnAddToCartProduct1;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement btnAddToCartProduct2;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement btnRemoveProduct1;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement btnRemoveProduct2;

    @FindBy(xpath = "//a[starts-with(text(), 'Twitter')]")
    WebElement btnTwitter;

    @FindBy(xpath = "//a[starts-with(text(), 'Facebook')]")
    WebElement btnFacebook;

    @FindBy(xpath = "//a[starts-with(text(), 'LinkedIn')]")
    WebElement btnLinkedin;

    @FindBy(id = "react-burger-menu-btn")
    WebElement btnMenuNavbar;

    @FindBy(id = "inventory_sidebar_link")
    WebElement navbarAllItems;

    @FindBy(id = "about_sidebar_link")
    WebElement navbarAbout;

    @FindBy(id = "logout_sidebar_link")
    WebElement navbarLogout;

    @FindBy(id = "reset_sidebar_link")
    WebElement navbarResetAppState;

    public InventoryPage(){
        PageFactory.initElements(driver, this);
    }


    public void clickBtnCart (){
        btnCart.click();
    }

    public String verifyTotalCart(){
        return btnCart.getText();
    }



    public void clickBtnDropDownListSort(){
        btnDropdownListSort.click();
    }

    public void clickBtnAddToCartProduct1(){
        btnAddToCartProduct1.click();
    }

    public void clickBtnRemoveProduct1(){
        btnRemoveProduct1.click();
    }

    public void clickBtnRemoveProduct2(){
        btnRemoveProduct2.click();
    }

    public void clickBtnAddToCartProduct2(){
        btnAddToCartProduct2.click();
    }

    public void clickBtnTwitter(){
        btnTwitter.click();
    }

    public void clickBtnFacebook(){
        btnFacebook.click();
    }
    public void clickBtnLinkedin(){
        btnLinkedin.click();
    }

    public void clickBtnMenuNavbar(){
        btnMenuNavbar.click();
    }

    public void clickBtnNavbarAbout(){
        navbarAbout.click();
    }

    public void clickBtnNavbarLogout(){
        navbarLogout.click();
    }

    public void clickProductName1(){
        txtProductName1.click();
    }

    public String getTextProductName1(){
        String productName = txtProductName1.getText();
        return productName;
    }

    public String getTextProductName2(){
        String productName = txtProductName2.getText();
        return productName;
    }


    public String getUrlInventoyPage(){
        return urlInventoyPage;
    }

    public boolean btnAddToCartProduct1Displayed(){
        boolean product1 = btnAddToCartProduct1.isDisplayed();
        return product1;
    }

    public boolean btnAddToCartProduct2Displayed(){
        boolean product2 = btnRemoveProduct2.isDisplayed();
        return product2;
    }
}
