package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReport {

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");


    @BeforeTest
    public void beforeTest(){
        extent.attachReporter(spark);
    }



    public void callTestCase1(String testcase){
        ExtentTest test = extent.createTest(testcase)
                .assignAuthor("maulana")
                        .assignCategory("smoke test")
                                .assignDevice("chrome");
        test.log(Status.INFO, "Username valid & Passowrd valid");
        test.log(Status.PASS, "Username valid & Passowrd valid");
        test.log(Status.WARNING, "Username valid & Passowrd valid");
        test.log(Status.SKIP, "Username valid & Passowrd valid");
        test.log(Status.FAIL, "Username valid & Passowrd valid");
    }

    @AfterTest
    public void aafterTest(){
        extent.flush();
    }


}
