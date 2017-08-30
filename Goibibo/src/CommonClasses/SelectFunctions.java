package CommonClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFunctions 
{
	WebDriver driver;
	
	public SelectFunctions(WebDriver driver){
		this.driver=driver;
	}
	
	public void selectByVisibleText(WebElement element,String Text){
		Select sel=new Select(element);
		sel.selectByVisibleText(Text);
	}
	
	public void selectByValue(WebElement element,String value){
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public void selectByIndex(WebElement element,int index){
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	

}
