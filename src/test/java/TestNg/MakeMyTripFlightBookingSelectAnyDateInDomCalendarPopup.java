package TestNg;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripFlightBookingSelectAnyDateInDomCalendarPopup  {
	WebDriver driver;

	@Test
	public void flight() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "V:\\Selenium Drivers2\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		Thread.sleep(2000);
		
		Actions act=new Actions(driver);            //This is because by defaultly after clicking from city page
		act.moveByOffset(10, 10).click().perform(); //is moving down
		
		//Navigate from and to elements
		WebElement src=driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
		WebElement dst=driver.findElement(By.xpath("//input[@data-cy='toCity']"));
		
		src.sendKeys("chennai");
		driver.findElement(By.xpath("//p[.='Chennai, India']")).click();
	    Thread.sleep(2000);
		dst.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='Sun May 21 2023']")).click();
		
	}
}





