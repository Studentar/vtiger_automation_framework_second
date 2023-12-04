package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CrazzhubCom {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("WebDriver.Chrome.driver","driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get("https://crazzyhub.com/");
		
	
		
	
	Actions obj=new Actions(driver);
	List<WebElement> MouseOver= driver.findElements(By.xpath("//div[@class=\"group capitalize inline-block relative\"]"));
	int tabCount=MouseOver.size();                
	for (int i=0; i<=tabCount-1; i++) {
		
	WebElement sub=	MouseOver.get(i);
	obj.moveToElement(sub).build().perform();
	List<WebElement> countSub = driver.findElements(By.xpath("//ul[@class='grid grid-cols-2 h-fit']"));
	int subTab=	countSub.size();
	for (int j=0; j <=subTab-1; j++) {
	 countSub = driver.findElements(By.xpath("//ul[@class='grid grid-cols-2 h-fit']"));
	WebElement allTab= countSub.get(j);
	String countSubTab=allTab.getText();
	System.out.println(countSubTab);
	allTab.click();
	Thread.sleep(500);
	driver.navigate().back();
	Thread.sleep(500);
	MouseOver= driver.findElements(By.xpath("//div[@class=\"group capitalize inline-block relative\"]"));
	sub=MouseOver.get(i);
	obj.moveToElement(sub).build().perform();
		
	}
	System.out.println("===========================");
	}	
	}
}