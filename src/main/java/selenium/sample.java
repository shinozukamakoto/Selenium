package selenium;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rakuplus.jp/");
		driver.findElement(By.cssSelector("#user_login")).sendKeys("");
		driver.findElement(By.cssSelector("#user_pass")).sendKeys("");
		driver.findElement(By.cssSelector("#wp-submit")).click();
		
		driver.get("https://rakuplus.jp/archives/11203");
		List<WebElement> divElemList = driver.findElements(By.cssSelector("section.entry-content > div"));	
		int count = 0;
		for(WebElement elem : divElemList) {
			if(count > 0) {
				WebElement imgElem = elem.findElement(By.tagName("img"));
				String url = imgElem.getAttribute("src");
				System.out.println(url);
				WebElement spanElem = elem.findElement(By.cssSelector("span.big"));
				System.out.println(spanElem.getText());
				WebElement pElem = elem.findElement(By.cssSelector("#\\31  > div.is-layout-flow.wp-block-column.is-vertically-aligned-top.visual > p"));
				System.out.println(pElem.getText());
			}
			
			System.out.println("-----------------------------");
			count++;
		}
	}
}

