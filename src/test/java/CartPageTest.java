import base.TestBase;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        boolean verify = cartPage.btnRemoveProduct1Displayed();
        Assert.assertTrue(verify);
    }

    @Test
    public void removeProductOnCartPage() {
        addProductToCart();
        cartPage.clickBtnRemoveProduct1();
        cartPage.clickBtnRemoveProduct2();
        String verifyTotalCart = cartPage.getTextTotalCart();
        Assert.assertEquals(verifyTotalCart,"");
    }


    @Test
    public void backToInventoryPage(){
        addProductToCart();
        cartPage.clickBtnShoping();
        String verifyTotalCart = cartPage.getTextTotalCart();
        Assert.assertEquals(verifyTotalCart,"2");
        boolean verifyBtnRemove1 = cartPage.btnRemoveProduct1Displayed();
        Assert.assertTrue(verifyBtnRemove1);
        boolean verifyBtnRemove2 = cartPage.btnRemoveProduct2Displayed();
        Assert.assertTrue(verifyBtnRemove2);

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}
