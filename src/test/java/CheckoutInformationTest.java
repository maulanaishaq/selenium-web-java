import base.TestBase;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutInformationPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutInformationTest extends TestBase {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;


    public CheckoutInformationTest(){
      super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutInformationPage = new CheckoutInformationPage();
    }

    @Test
    public void checkoutInformation(){
        loginPage.setTxtUsername("standard_user");
        loginPage.setTxtPassword("secret_sauce");
        loginPage.setBtnLogin();
        inventoryPage.clickBtnAddToCartProduct1();
        inventoryPage.clickBtnAddToCartProduct2();
        inventoryPage.clickBtnCart();
        cartPage.clickBtnCheckout();
        String verifyPage = checkoutInformationPage.getTitleCheckoutYourInformation();
        Assert.assertEquals(verifyPage, "CHECKOUT: YOUR INFORMATION");
    }


    @Test
    public void backToCart(){
        checkoutInformation();
        checkoutInformationPage.clickBtnCancel();
        String actualTitle = cartPage.getTitleCart();
        Assert.assertEquals(actualTitle, "YOUR CART");
    }

    @Test
    public void checkoutOverview(){
        checkoutInformation();
        checkoutInformationPage.inputFirstName("maulana");
        checkoutInformationPage.inputLastName("ishaq");
        checkoutInformationPage.inputPostalCode("11111");
        checkoutInformationPage.clickBtnContinue();
        String product1 = inventoryPage.getTextProductName1();
        Assert.assertEquals(product1, "Sauce Labs Backpack");
        String product2 = inventoryPage.getTextProductName2();
        Assert.assertEquals(product2, "Sauce Labs Bike Light");

    }

    @Test
    public void checkoutProductEmpty(){
        loginPage.setTxtUsername("standard_user");
        loginPage.setTxtPassword("secret_sauce");
        loginPage.setBtnLogin();
        inventoryPage.clickBtnAddToCartProduct1();
        inventoryPage.clickBtnAddToCartProduct2();
        inventoryPage.clickBtnCart();
        cartPage.clickBtnRemoveProduct1();
        cartPage.clickBtnRemoveProduct2();
        cartPage.clickBtnCheckout();
        checkoutInformationPage.clickBtnContinue();

        String actualTotalCart = cartPage.getTextTotalCart();
        Assert.assertEquals(actualTotalCart, "");

    }

    @Test
    public void getErrorFirstname(){
        checkoutInformation();
        checkoutInformationPage.clickBtnContinue();
        String actualFirstname = checkoutInformationPage.getTextErrorFirstname();
        Assert.assertEquals(actualFirstname, "Error: First Name is required");
    }

    @Test
    public void getErrorLastname(){
        checkoutInformation();
        checkoutInformationPage.inputFirstName("maulana");
        checkoutInformationPage.clickBtnContinue();
        String actualLastname = checkoutInformationPage.getTextErrorLastname();
        Assert.assertEquals(actualLastname, "Error: Last Name is required");
    }

    @Test
    public void getErrorPostalCode(){
        checkoutInformation();
        checkoutInformationPage.inputFirstName("maulana");
        checkoutInformationPage.inputLastName("ishaq");
        checkoutInformationPage.clickBtnContinue();
        String actualPostalcode = checkoutInformationPage.getTextErrorPostalCode();
        Assert.assertEquals(actualPostalcode, "Error: Postal Code is required");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
