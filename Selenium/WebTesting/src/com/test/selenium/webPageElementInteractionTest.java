package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class webPageElementInteractionTest {

	static WebDriver driver = new ChromeDriver();
	static Actions act = new Actions(driver);
	
	public static void main(String[] args) {

		//Enabling the WebDriver and Login of the Application
        initiateDriver();
        
        //Enabling the components to be used
        assignComponents();
        
        //Calculating the value evaluated after above operations
        getLoanValue();
	}
	
	public static void setUnsuccessMsg() {
		System.out.println("Unable to process !");
	}
	
    public static void initiateDriver() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        try {
        	driver.manage().window().maximize();
            driver.get("https://emicalculator.net/");           
            
        } catch (Exception e) {
            setUnsuccessMsg();
        }
    }
    
    public static void assignComponents() {

        try {
           WebElement loanComponent = driver.findElement(By.cssSelector("#loanamountslider >span"));     
           WebElement interestComponent = driver.findElement(By.cssSelector("#loaninterestslider >span"));     
           WebElement tenureComponent = driver.findElement(By.cssSelector("#loantermslider >span"));     
           
           performDragActions(loanComponent, 83, 0);
           
           performDragActions(interestComponent, 88, 0);
           
           performDragActions(tenureComponent, -111, 0);
           
        } catch (Exception e) {
            setUnsuccessMsg();
        }
    }
    
    //@params -> component - WebElement - the DOM Element used ; x,y - int - the pixel value to be moved in respective direction
    public static void performDragActions(WebElement component, int x, int y) throws InterruptedException {
    	 act.dragAndDropBy(component,x,y).build().perform();
         Thread.sleep(2000);
    }
    
    public static void getLoanValue() {
    	
    	WebElement loanComponent = driver.findElement(By.cssSelector("#emiamount >p >span"));   
    	System.out.println("The Loan EMI equals -> " + loanComponent.getText());
    }
}
