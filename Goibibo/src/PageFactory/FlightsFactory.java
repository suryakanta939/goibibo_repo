package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonClasses.ActionFunctions;
import CommonClasses.SelectFunctions;

public class FlightsFactory {
    WebDriver driver;
    boolean flag=true;
    SelectFunctions sel=new SelectFunctions(driver);
    
    String xpath1="//tbody[tr[td[text()='February 2017']]]//span[text()='";
    String xpath2="']";
    
    @FindBy(id="gi_oneway_label")
    WebElement onewayBtn;
    
    
    @FindBy(id="gi_source_st")
    WebElement fromtextBox;
    
    
    @FindBy(id="gi_destination_st")
    WebElement toTextBox;
    
   //changed here "e" 
    @FindBy(id="start-date")
    WebElement departureDate;
    
    
    @FindBy(id="jrdp_start-calen_nextmonth_multi_1")
    WebElement nextBtn;
    
    @FindBy(id="pax_link_common")
    WebElement traveller;
    
    
    @FindBy(xpath="//select[@name='Adult']")
    WebElement adult;
    
    @FindBy(xpath="//select[@name='Children']")
    WebElement children;
    
    @FindBy(id="pax_close")
    WebElement close;
    
    @FindBy(id="gi_class")
    WebElement classType;
    /*
     * for more option
     * */ 
    
    @FindBy(xpath="html/body/div[1]/div[1]/ul/li[7]/div")
    WebElement moreoptions;
/*
 * for go Package
 * */    
  
    @FindBy(xpath="//span[text()='Go Packages']")
    WebElement gopackage;
    
    @FindBy(xpath="//a[@href='http://www.redbus.in/']")
    WebElement redbusLink;
    
    public FlightsFactory(WebDriver driver){
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    
    public void clickOnewayBtn(){
    	onewayBtn.click();
    }
    
    public void fillfromDestination(String from){
    	fromtextBox.clear();
    	fromtextBox.sendKeys(from);
    	driver.findElement(By.xpath("//*[@id='source_st']/div/ul/li[1]")).click();
    }
    
    public void fillToDestination(String to){
    	toTextBox.clear();
    	toTextBox.sendKeys(to);
    	driver.findElement(By.xpath("//*[@id='destination_st']/div/ul/li")).click();
    }
    
    public void selectDeparturedate(String date){
    	departureDate.click();
    	while(true){
    		try{
    			driver.findElement(By.xpath(xpath1+date+xpath2)).click();
    			break;
    		}
    		catch(Throwable t){
    			nextBtn.click();
    		}
    	}
    	
    }
    
    public void selectTraveller(String adultno,String childno){
    	traveller.click();
    	sel.selectByVisibleText(adult, adultno);
    	sel.selectByValue(children, childno);
    	close.click();
    	
    }
    
    public void selectClassType(String typetext){
    	 sel=new SelectFunctions(driver);
    	sel.selectByVisibleText(classType,typetext);
    }
    
    public void clickonRedBus(){
    	redbusLink.click();
    }
    public void clickOnGoPackage(){
    	 ActionFunctions actfun=new ActionFunctions(driver);
    	actfun.hoveronelement(moreoptions);
    	actfun.openLinkInNewTab(gopackage);
    	
    }
    public void switchToGoPackageTab(){
    	 ActionFunctions actfun=new ActionFunctions(driver);
    	 actfun.switchedToTab();
    }
}
