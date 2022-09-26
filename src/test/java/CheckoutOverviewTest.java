import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutOverviewTest extends TestBase {
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;

    CheckoutOverviewPage checkoutOverviewPage;


    public CheckoutOverviewTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutInformationPage = new CheckoutInformationPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
    }


    @Test
    public void checkoutFinish(){
        loginPage.setTxtUsername("standard_user");
        loginPage.setTxtPassword("secret_sauce");
        loginPage.setBtnLogin();
        inventoryPage.clickBtnAddToCartProduct1();
        inventoryPage.clickBtnAddToCartProduct2();
        inventoryPage.clickBtnCart();
        cartPage.clickBtnCheckout();
        checkoutInformationPage.inputFirstName("maulana");
        checkoutInformationPage.inputLastName("ishaq");
        checkoutInformationPage.inputPostalCode("2102912");
        checkoutInformationPage.clickBtnContinue();
        checkoutOverviewPage.clickBtnFinish();
        String actualThanksMessage = checkoutOverviewPage.getTextThankyouOrder();
        Assert.assertEquals(actualThanksMessage, "THANK YOU FOR YOUR ORDER");
    }


    @Test
    public void CancelCheckout(){
        loginPage.setTxtUsername("standard_user");
        loginPage.setTxtPassword("secret_sauce");
        loginPage.setBtnLogin();
        inventoryPage.clickBtnAddToCartProduct1();
        inventoryPage.clickBtnAddToCartProduct2();
        inventoryPage.clickBtnCart();
        cartPage.clickBtnCheckout();
        checkoutInformationPage.inputFirstName("maulana");
        checkoutInformationPage.inputLastName("ishaq");
        checkoutInformationPage.inputPostalCode("2102912");
        checkoutInformationPage.clickBtnContinue();
        checkoutOverviewPage.clickBtnCancel();
        String actualUrl = driver.getCurrentUrl();
        String expected = inventoryPage.getUrlInventoyPage();
        Assert.assertEquals(actualUrl, expected);
    }

    @Test
    public void backToHome(){
        checkoutFinish();
        checkoutOverviewPage.clickBtnHome();
        String actualUrl = driver.getCurrentUrl();
        String expected = inventoryPage.getUrlInventoyPage();
        Assert.assertEquals(actualUrl, expected);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
