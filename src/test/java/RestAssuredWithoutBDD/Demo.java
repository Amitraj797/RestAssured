package RestAssuredWithoutBDD;

import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Demo {
	
	public static void main(String[] args) {
		
	WebDriver driver = new ChromeDriver();
	Actions act = new Actions(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demoqa.com/automation-practice-form");
	driver.findElement(By.cssSelector("[placeholder='First Name']")).sendKeys("Bidhayak");
	driver.findElement(By.cssSelector("[placeholder='Last Name']")).sendKeys("Das");
	driver.findElement(By.cssSelector("[placeholder='name@example.com']")).sendKeys("Bidhayakdas@gmail.com");
	driver.findElement(By.xpath("//div[@id='genterWrapper']/div[2]/div[1]")).click();
	driver.findElement(By.cssSelector("[placeholder='Mobile Number']")).sendKeys("6854712548");
	driver.findElement(By.cssSelector("[id='dateOfBirthInput']")).click();
	WebElement w =driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
	Select s = new Select(w);
	s.selectByVisibleText("December");
	WebElement w1 =driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
	Select s1 = new Select(w1);
	s1.selectByVisibleText("1995");
	WebElement w3 =driver.findElement(By.xpath("//div[@aria-label='Choose Friday, December 22nd, 1995']"));
	w3.click();
	act.scrollByAmount(0, 200).perform();
	driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div[1]")).click();
	driver.findElement(By.xpath("//div[@id='subjectsWrapper']/div[2]/div[1]/div/div")).sendKeys("english","commerce");
	driver.findElement(By.xpath("//label[text()='Picture']/../../div[2]/div/input[@id='uploadPicture']")).click();

	
	
//	JavascriptExecutor jse = (JavascriptExecutor) driver;  
//	jse.executeScript("document.getElementById('gender-radio-1')");

	
	
	
//	driver.findElement(By.xpath("//input[@value='Male']")).click();
	
	
	
//	driver.findElement(By.cssSelector("[placeholder='Last Name']")).sendKeys("Das");
//	driver.findElement(By.cssSelector("[placeholder='Last Name']")).sendKeys("Das");
}
}