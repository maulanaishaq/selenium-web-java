package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TestBase {

    public static WebDriver driver;
    public static Properties properties;


    public TestBase(){

        try {
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream
                    (System.getProperty("user.dir")+ "/src/main/java" + "/config/config.properties");
            properties.load(inputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }else if (browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browserName.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else {
            System.out.printf("browser not found");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        TestUtil.pageLoadTimeOut();
        driver.get(properties.getProperty("url"));

    }




}
