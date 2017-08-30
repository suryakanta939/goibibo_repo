package CommonClasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShotClass {
	WebDriver driver;
	public ScreenShotClass(WebDriver driver){
		this.driver=driver;
	}
	public String takeScreenShot(String filename) throws IOException{
		 filename=filename+".png";
		 String dirc="E:\\SELENIUM_PROGRAM\\Goibibo\\ScreenShot\\";
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File srcfile=edriver.getScreenshotAs(OutputType.FILE);
		File destfile=new File(dirc+filename);
		FileUtils.copyFile(srcfile, destfile);
		String destinationFile=dirc+filename;
		return destinationFile;
	}

}
