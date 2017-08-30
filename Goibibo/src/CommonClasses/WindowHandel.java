package CommonClasses;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandel {
   
	 
    WebDriver driver;
	
	public WindowHandel(WebDriver driver){
		this.driver=driver;
	}
   /*this function is to be used when there will be more two windows*/	
	 public void switchtoWindow(){
		 String parendhandel=driver.getWindowHandle();
		Set<String> childIds=driver.getWindowHandles(); 
		for(String childId:childIds){
			if(!childId.equals(parendhandel)){
				driver.switchTo().window(childId);
			}
		}
		
	 }
	
	//this is for switching main window from multiple window
	 
	 public void switchingToMainWIndow(){
		 Set<String> parendhandels=driver.getWindowHandles();
		 System.out.println("The total windows are"+parendhandels.size());
		 if(parendhandels.size()==1){
			 for(String parentid: parendhandels){
				 driver.switchTo().window(parentid);
			 }
		 }
	 }
	//this is for switching main window from multiple window & also to parent window
	 public void swithcToMultipleWindows(String pageTitle){
		 String parendhandel=driver.getWindowHandle();
			Set<String> childIds=driver.getWindowHandles(); 
			for(String childId:childIds){
				if(!childId.equals(parendhandel)){
					driver.switchTo().window(childId);
					
				//	get the title of the current page
					String currentTitle=driver.getTitle();
					System.out.println(currentTitle);
					if(currentTitle.equals(pageTitle)){
						driver.switchTo().window(childId);
					}
				}
			}
	 }
}
