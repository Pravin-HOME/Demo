package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers\\ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/");

		WebElement weFrame = driver.findElement(By.xpath("//iframe[@src='/howto/tryhow_js_slideshow_ifr.htm']"));
		driver.switchTo().frame(weFrame);

		String weFrameText=driver.findElement(By.xpath("//div[text()='Caption Text']")).getText();
		System.out.println(weFrameText);

		driver.switchTo().defaultContent();

		String weText=driver.findElement(By.xpath("//a[text()='LEARN HOW TO']")).getText();
		System.out.println(weText);
	}

}
