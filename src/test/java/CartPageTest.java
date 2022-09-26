import base.TestBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;


public class CartPageTest extends TestBase {
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;


    public CartPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
    }

    @Test
    public void addProductToCart(){
        loginPage.setTxtUsername("standard_user");
        loginPage.setTxtPassword("secret_sauce");
        loginPage.setBtnLogin();
        inventoryPage.clickBtnAddToCartProduct1();
        inventoryPage.clickBtnAddToCartProduct2();
        inventoryPage.clickBtnCart();
        boolean verify = driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
        Assert.assertTrue(verify);
    }

    @Test
    public void removeProductOnCartPage() {
        addProductToCart();
        cartPage.clickBtnRemoveProduct1();
        cartPage.clickBtnRemoveProduct2();
        String verifyTotalCart = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        Assert.assertEquals(verifyTotalCart,"");
    }


    @Test
    public void backToInventoryPage(){
        addProductToCart();
        cartPage.clickBtnShoping();
        String verifyTotalCart = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
        Assert.assertEquals(verifyTotalCart,"2");
        boolean verifyBtnRemove1 = driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
        Assert.assertTrue(verifyBtnRemove1);
        boolean verifyBtnRemove2 = driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed();
        Assert.assertTrue(verifyBtnRemove2);

    }







}
