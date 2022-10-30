package demo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindow {
	
	public static void main(String[] args) {
		
	    System.setProperty("webdriver.chrome.driver","drivers\\ChromeDriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demoqa.com/browser-windows");
	    
	    driver.findElement(By.id("windowButton")).click();
	    
	    driver.findElement(By.id("messageWindowButton")).click();
	    
	    String MainWindow = driver.getWindowHandle();
	    
	    System.out.println("Main window handle is " + MainWindow);

	    // To handle all new opened window
	    Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();

		      while (i1.hasNext()) {
	          String ChildWindow = i1.next();
	          if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
	              driver.switchTo().window(ChildWindow);
	              driver.close();
	              System.out.println("Child window closed");
	           }
	       }
		
	}

}
