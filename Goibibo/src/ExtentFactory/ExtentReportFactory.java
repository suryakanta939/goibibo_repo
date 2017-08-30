package ExtentFactory;

import com.relevantcodes.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportFactory {
   public static ExtentHtmlReporter getinstance(){
	   ExtentHtmlReporter extent;
	   String path="C:\\Users\\ad\\Desktop\\report\\goibibo.html";
	   extent=new ExtentHtmlReporter(path);
	  // extent.config().s
	   return extent;
	   
   }
}
