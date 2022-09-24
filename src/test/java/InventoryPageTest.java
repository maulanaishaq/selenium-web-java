import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.TestUtil;


public class InventoryPageTest extends TestBase {

    InventoryPage inventoryPage;

    LoginPage loginPage;

    public InventoryPageTest(){
        super();

    }

    @BeforeMethod
    public void setUp(){
        initialization();
        inventoryPage = new InventoryPage();
        loginPage = new LoginPage();
    }


    @Test
    public void loginSuccess(){
        loginPage.setTxtUsername("standard_user");
        loginPage.setTxtPassword("secret_sauce");
        loginPage.setBtnLogin();
        boolean verifyElement = driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed();
        Assert.assertTrue(verifyElement);
    }

    @Test
    public void addProductsToCart()  {
        loginSuccess();
        TestUtil.waitElementVisible(inventoryPage.btnAddToCartProduct1);
        inventoryPage.clickBtnAddToCartProduct1();
        inventoryPage.clickBtnAddToCartProduct2();
        String totalCart = inventoryPage.verifyTotalCart();
        Assert.assertEquals(totalCart, "2");
    }


    @Test
    public void removeProductCart() throws InterruptedException {
        addProductsToCart();
        inventoryPage.clickBtnRemoveProduct1();
        inventoryPage.clickBtnRemoveProduct2();
        Thread.sleep(2000);
        String totalCart = inventoryPage.verifyTotalCart();
        Assert.assertEquals(totalCart, "");
    }


    @Test
    public void openTwitterPage() throws InterruptedException {
        loginSuccess();
        Thread.sleep(3000);
        inventoryPage.clickBtnTwitter();
        Thread.sleep(3000);
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://twitter.com/saucelabs";
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test
    public void openFacebookPage() throws InterruptedException {
        loginSuccess();
        TestUtil.waitElementVisible(inventoryPage.btnAddToCartProduct1);
        inventoryPage.clickBtnFacebook();
        Thread.sleep(3000);
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/saucelabs";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void openLinkedinPage() throws InterruptedException {
        loginSuccess();
        TestUtil.waitElementVisible(inventoryPage.btnAddToCartProduct1);
        inventoryPage.clickBtnLinkedin();
        Thread.sleep(3000);
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String actualUrl = driver.findElement(By.xpath("//h1[starts-with(text(), \"Join LinkedIn\")]")).getText();
        String expectedUrl = "Join LinkedIn";
        Assert.assertEquals(actualUrl, expectedUrl);
    }


    @Test
    public void openAboutPage() throws InterruptedException {
        loginSuccess();
        TestUtil.waitElementVisible(inventoryPage.btnAddToCartProduct1);
        inventoryPage.clickBtnMenuNavbar();
        inventoryPage.clickBtnNavbarAbout();
        Thread.sleep(3000);
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://saucelabs.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void logout() throws InterruptedException {
        loginSuccess();
        TestUtil.waitElementVisible(inventoryPage.btnAddToCartProduct1);
        inventoryPage.clickBtnMenuNavbar();
        inventoryPage.clickBtnNavbarLogout();
        Thread.sleep(3000);
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
