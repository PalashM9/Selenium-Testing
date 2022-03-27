package com.test.selenium;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class webPageElementInteractionTestTwo {

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
           WebElement loanComponent = driver.findElement(By.id("loanamount"));     
           WebElement interestComponent = driver.findElement(By.id("loaninterest"));     
           WebElement tenureComponent = driver.findElement(By.id("loanterm"));     
           
           performActions(loanComponent, "loan amount");
           
           performActions(interestComponent, "interest amount");
           
           performActions(tenureComponent, "tenure amount");
           
        } catch (Exception e) {
            setUnsuccessMsg();
        }
    }
    
    //@params -> component - WebElement - the DOM Element used ; attribute - string - the loan attribute provided
    public static void performActions(WebElement component, String attribute) throws InterruptedException {
    	
    	 
	   	 component.clear();	
	   	 component.click();
	   	 clearTextAndPreSelected(component);
	   	 
    	 Scanner sc = new Scanner(System.in);
    	 System.out.println("Enter the amount of " + attribute + " to be added");
    	 String value = sc.next();
    	 
    	 clearTextAndPreSelected(component);
    	 component.sendKeys(value);
    	 component.sendKeys(Keys.RETURN);
         
         Thread.sleep(2000);
    }
    
    public static void getLoanValue() {
    	
    	WebElement loanComponent = driver.findElement(By.cssSelector("#emiamount >p >span"));   
    	System.out.println("The Loan EMI equals -> " + loanComponent.getText());
    }
    
    public static void clearTextAndPreSelected(WebElement component) {
    	 component.sendKeys(Keys.CONTROL + "a");
	   	 component.sendKeys(Keys.DELETE);
    }
}
