package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webPageTest {

    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) {

        //Enabling the WebDriver and Login of the Application
        initiateDriver();

        //After Login, searching for major component present in all spotify post-login message
        By accntSettingsLink = By.id("account-settings-link");
        enableWaitingForElementToLoad(accntSettingsLink);

        //Initiating movement towards the webplayer
        initiateNavigationToPlayer();

        //Searching for search button to open search input-bar
        By searchButtonLink = By.xpath("//*[@id=\"main\"]/div/div[2]/nav/div[1]/ul/li[2]/a");
        enableWaitingForElementToLoad(searchButtonLink);

        //Enabling search bar and searching the song to play
        initiateSearchBarAndPlay();

        //Checking the url
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        //driver.close();

    }

    public static void initiateDriver() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        try {
            driver.get("https://accounts.spotify.com/en/login?continue=https");
            driver.findElement(By.id("login-username")).sendKeys("palashm0002@gmail.com");
            driver.findElement(By.id("login-password")).sendKeys("ilovemusic");
            driver.findElement(By.id("login-button")).click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            setUnsuccessMsg();
        }
    }

    public static void setSuccessMsg() {
        System.out.println("Login successfully !!");
    }

    public static void setUnsuccessMsg() {
        System.out.println("Unable to move further !!");
    }

    //@params - the location of the DOM by means of path\id
    public static void enableWaitingForElementToLoad(By location) {
        try {
            WebElement elementToWait =
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(location));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            setUnsuccessMsg();
        }
    }

    public static void initiateNavigationToPlayer() {
        try {
            WebElement WebPlayerBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/button[2]"));
            WebPlayerBtn.click();
            setSuccessMsg();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            setUnsuccessMsg();
        }
    }

    public static void initiateSearchBarAndPlay() {
        try {
            WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/nav/div[1]/ul/li[2]/a"));
            searchBtn.click();

            By searchBar = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/div[3]/div/div/form/input");
            enableWaitingForElementToLoad(searchBar);

            WebElement searchBarComponent = driver.findElement(searchBar);

            searchBarComponent.click();
            searchBarComponent.sendKeys("Yellow");
            searchBarComponent.sendKeys(Keys.RETURN);

            By acceptCookies = By.id("onetrust-accept-btn-handler");
            enableWaitingForElementToLoad(acceptCookies);
            WebElement acceptCookiesBtn = driver.findElement(acceptCookies);
            By playFooter = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/footer/div/div[2]/div/div[1]/button");
            enableWaitingForElementToLoad(playFooter);
            acceptCookiesBtn.click();

            By playComponent = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/footer/div/div[2]/div/div[1]/button");
            enableWaitingForElementToLoad(playComponent);
            WebElement playSong = driver.findElement(playComponent);
            playSong.click();
            playSong.click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            setUnsuccessMsg();
        }


    }

}