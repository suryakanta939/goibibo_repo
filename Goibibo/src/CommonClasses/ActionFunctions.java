package CommonClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ActionFunctions {
   
    WebDriver driver;
	
	public ActionFunctions(WebDriver driver){
		this.driver=driver;
	}
   
	public void hoveronelement(WebElement element){
		
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
	}
	
  public void dragAndDrop(WebElement from,WebElement to){
		
		Actions act =new Actions(driver);
		act.clickAndHold(from).perform();
		act.moveToElement(to).perform();
		act.release().perform();
	}

	public void rightClick(WebElement element){
		Actions act =new Actions(driver);
		act.contextClick(element).perform();
	}
/*
 * this function is to right click on element
 * den open the link in a new tab
 * */
	public void openLinkInNewTab(WebElement element){
		Actions act =new Actions(driver);
		act.contextClick(element).perform();
		act.sendKeys("T").perform();
	}
/*
 * Swithced to anothertab
 * */	
	
	public void switchedToTab(){
		Actions act =new Actions(driver);
		act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
	}
}
