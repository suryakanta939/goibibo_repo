package TestScripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.ast.NewExpression;

import org.apache.xmlbeans.impl.store.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.Status;
import com.relevantcodes.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.reporter.ExtentXReporter;

import CommonClasses.ActionFunctions;
import CommonClasses.ScreenShotClass;
import CommonClasses.WindowHandel;
import ExtentFactory.ExtentReportFactory;
import PageFactory.FlightsFactory;

public class Flights {
	 WebDriver driver;
	 String baseUrl="https://www.goibibo.com/";
	 FlightsFactory flightpage;
	 WindowHandel handel;
	 ExtentReports extent;
	 ExtentTest test;
	 ExtentHtmlReporter htmlReporter;
	
      
  @BeforeClass
  public void beforeClass() {
	   htmlReporter = ExtentReportFactory.getinstance();
	 // ExtentXReporter extentxReporter = new ExtentXReporter("localhost");

	   extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	   test = extent.createTest("My First Test");
	  
	  
	  driver=new FirefoxDriver();
	  driver.get(baseUrl);
	  test.log(Status.INFO, "browser started");
	  flightpage=new FlightsFactory(driver);
	  driver.manage().window().maximize();
	  test.log(Status.INFO, "browser maximized");
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  test.log(Status.INFO, "application opened ");
  }
  
  @Test
  public void f() throws InterruptedException {
	 
	  
	  flightpage.clickOnewayBtn();
	  test.log(Status.INFO, "clicked on oneway btn ");
	  flightpage.fillfromDestination("bang");
	  test.log(Status.INFO, "choosing the destination from");
	  flightpage.fillToDestination("bhub");
	  test.log(Status.INFO, "choosing the destination to ");
	  flightpage.selectDeparturedate("20");
	  test.log(Status.INFO, "choosing the departure date ");
	  flightpage.selectTraveller("4","3");
	  flightpage.selectClassType("First Class");
	  //scroll up
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,-500)","");
	  Thread.sleep(2000);
	  flightpage.clickonRedBus();
	  handel=new WindowHandel(driver);
	  handel.switchtoWindow();
	 // driver.findElement(By.xpath("//span[contains(text(),'EARN RS 100')]")).click();
	  String msg=driver.findElement(By.xpath("//span[contains(text(),'EARN RS 100')]")).getText();
	  System.out.println(msg);
	  driver.close();
	  handel.switchingToMainWIndow();
	  flightpage.clickOnGoPackage();
	  flightpage.switchToGoPackageTab();
	  handel.switchingToMainWIndow();
	  driver.findElement(By.xpath("//span[text()='Bus']")).click();
	  
//	  handel.swithcToMultipleWindows("Online Bus Tickets,Volvo AC Booking,RTCs Rservations");
//	  driver.findElement(By.xpath("//a[text()='BUS HIRE']")).click();
	
  }
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException{
	  if(result.getStatus()==ITestResult.FAILURE){
		  ScreenShotClass ss=new ScreenShotClass(driver);
		  String path=ss.takeScreenShot(result.getMethod().getMethodName());
		  test.addScreenCaptureFromPath(path).fail("fail");
		  test.log(Status.FAIL, result.getThrowable());
	  }
	  else if (result.getStatus() == ITestResult.SKIP) {
          test.log(Status.SKIP, "Test skipped " + result.getThrowable());
	  }
	  else{
		  test.log(Status.PASS, "Test passed");
	  }
	 
  }
  
  @AfterClass
  public void afterClass() {
    System.out.println("checked it ");  
    test.assignAuthor("Suryakanta sahoo");
    extent.flush();
    driver.quit();
   // htmlReporter.config();
   // extentxReporter.config();
  }
}
