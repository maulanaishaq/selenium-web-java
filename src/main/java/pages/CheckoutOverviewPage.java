package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends TestBase {

   @FindBy(id = "finish")
    WebElement btnFinish;

   @FindBy(id = "cancel")
    WebElement btnCancel;

   @FindBy(id = "back-to-products")
   WebElement btnBackHome;

   public CheckoutOverviewPage(){
       PageFactory.initElements(driver, this);
   }


   public void clickBtnFinish(){
       btnFinish.click();
   }

   public void clickBtnCancel(){
       btnCancel.click();
   }

   public void clickBtnHome(){
       btnBackHome.click();
   }


}
