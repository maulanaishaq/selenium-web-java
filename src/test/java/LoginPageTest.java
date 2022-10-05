import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.TestUtil;



public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    InventoryPage inventoryPage;


   public LoginPageTest(){
       super();
   }

   @BeforeMethod
   public void setUp(){
       initialization();
       loginPage = new LoginPage();
       inventoryPage = new InventoryPage();
   }

   @Test
   public void loginSuccess(){
       loginPage.setTxtUsername("standard_user");
       loginPage.setTxtPassword("secret_sauce");
       loginPage.setBtnLogin();
       boolean verifyElement = inventoryPage.btnAddToCartProduct1Displayed();
       Assert.assertTrue(verifyElement);
   }

   @Test
   public void loginSuccessSlowConnection(){
       loginPage.setTxtUsername("performance_glitch_user");
       loginPage.setTxtPassword("secret_sauce");
       loginPage.setBtnLogin();
       boolean verifyElement = inventoryPage.btnAddToCartProduct1Displayed();
       Assert.assertTrue(verifyElement);
   }

   @Test
   public void loginSuccessProblemUser(){
       loginPage.setTxtUsername("problem_user");
       loginPage.setTxtPassword("secret_sauce");
       loginPage.setBtnLogin();
       boolean verifyElement = driver.findElement(By.xpath("//a [@id = 'item_4_img_link']//img[@src='/static/media/sl-404.168b1cce.jpg']")).isDisplayed();
       Assert.assertTrue(verifyElement);

   }


   @Test
   public void loginSessionOver() {
       loginPage.setTxtUsername("locked_out_user");
       loginPage.setTxtPassword("secret_sauce");
       loginPage.setBtnLogin();
       String actualMessage = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
       String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
       Assert.assertEquals(actualMessage, expectedMessage);
       TestUtil.takeScreenshot();

   }


    @Test
    public void loginInvalidUsername() {
        loginPage.setTxtUsername("arum");
        loginPage.setTxtPassword("secret_sauce");
        loginPage.setBtnLogin();
        String actualMessage = driver.findElement(By.xpath("//h3[@data-test =\"error\"]")).getText();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualMessage, expectedMessage);
        TestUtil.takeScreenshot();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
