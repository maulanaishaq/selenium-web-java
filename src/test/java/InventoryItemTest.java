import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryItemPage;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryItemTest extends TestBase {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    InventoryItemPage itemPage;


    public InventoryItemTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        itemPage = new InventoryItemPage();
    }


    @Test
    public void openInventoryItemPage() {
        loginPage.setTxtUsername("standard_user");
        loginPage.setTxtPassword("secret_sauce");
        loginPage.setBtnLogin();
        inventoryPage.clickProductName1();
        boolean verify = itemPage.btnBackToProductsDisplayed();
        Assert.assertTrue(verify);

    }

    @Test
    public void addToCart() {
        openInventoryItemPage();
        itemPage.clickBtnAddToCart();
        String verifyTotalCart = inventoryPage.verifyTotalCart();
        String expectedTotalCart = "1";
        Assert.assertEquals(verifyTotalCart, expectedTotalCart);

    }

    @Test
    public void removeCart() {
        addToCart();
        itemPage.clickBtnRemove();
        String verifyTotalCart = inventoryPage.verifyTotalCart();
        System.out.println(verifyTotalCart);
        String expectedTotalCart = "";
        Assert.assertEquals(verifyTotalCart, expectedTotalCart);
    }


    @Test
    public void backToInventoryPage(){
        openInventoryItemPage();
        itemPage.clickBtnBackToProducts();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = inventoryPage.getUrlInventoyPage();
        Assert.assertEquals(actualUrl, expectedUrl);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
