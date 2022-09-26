package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage extends TestBase {

    @FindBy(id = "back-to-products")
    WebElement btnBackToProducts;

    @FindBy(xpath= "//button[@class = 'btn btn_primary btn_small btn_inventory']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//a[@class = 'shopping_cart_link']")
    WebElement btnCart;

    @FindBy(xpath = "//button[starts-with(text(), 'Remove')]")
    WebElement btnRemove;


    public InventoryItemPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickBtnBackToProducts(){
        btnBackToProducts.click();
    }


    public void clickBtnAddToCart(){
        btnAddToCart.click();
    }

    public void clickBtnCart(){
        btnCart.click();
    }

    public void clickBtnRemove(){
        btnRemove.click();
    }

    public boolean btnBackToProductsDisplayed(){
        boolean display = btnBackToProducts.isDisplayed();
        return display;
    }

}
