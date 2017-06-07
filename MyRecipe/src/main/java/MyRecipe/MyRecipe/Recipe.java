package MyRecipe.MyRecipe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recipe {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try
		{	
		
			//set path to HTML file
			String pathToHtml = "file:///" + System.getProperty("user.dir") + "\\recipe.html";		
			
			//set path to geckodriver which allows us to use Firefox
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\lib\\geckodriver.exe");
			
			//create an object to open a Firefox window
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//capabilities.setCapability("marionette", true);
			WebDriver driver = new FirefoxDriver();
	
			// And now use this to visit the HTML site
	        driver.get(pathToHtml);
			
	        //Get the 3rd item from the list
	        WebElement thirdItem = driver.findElement(By.xpath("//span[@class='title ng-binding'][3]"));
	        System.out.println("3rd Item: " + thirdItem.getText());

	        //Get the 5th item from the list
	        WebElement fifthItem = driver.findElement(By.xpath("//span[@class='title ng-binding'][5]"));
	        System.out.println("5th Item: " + fifthItem.getText());
	        
	        //Use a HashMap to store each food name and its servings
			HashMap foodServings = new HashMap();
	        
	        //Assuming this is a static website, we know there's 5 items, so we can use xpaths with indices to get each one.
	        foodServings.put(driver.findElement(By.xpath("//span[@class='title ng-binding'][1]")).getText(), driver.findElement(By.xpath("//span[@class='description ng-binding'][1]")).getText());
	        foodServings.put(driver.findElement(By.xpath("//span[@class='title ng-binding'][2]")).getText(), driver.findElement(By.xpath("//span[@class='description ng-binding'][2]")).getText());
	        foodServings.put(driver.findElement(By.xpath("//span[@class='title ng-binding'][3]")).getText(), driver.findElement(By.xpath("//span[@class='description ng-binding'][3]")).getText());
	        foodServings.put(driver.findElement(By.xpath("//span[@class='title ng-binding'][4]")).getText(), driver.findElement(By.xpath("//span[@class='description ng-binding'][4]")).getText());
	        foodServings.put(driver.findElement(By.xpath("//span[@class='title ng-binding'][5]")).getText(), driver.findElement(By.xpath("//span[@class='description ng-binding'][5]")).getText());

	        //Iterate and print each entry (key + value) in the map
	        Iterator it = foodServings.entrySet().iterator();
	        System.out.println("----------------------------------------");
	        while (it.hasNext()) 
	        {
	            Map.Entry pair = (Map.Entry)it.next();
	            System.out.println(pair.getKey() + " = " + pair.getValue());
	        }
	        System.out.println("----------------------------------------");

	        
	        //close the browser
	        driver.quit();
		}
		catch(Exception e)
		{
			System.out.println("Failed due to exception");
			e.printStackTrace();
			
		}
	}

}
