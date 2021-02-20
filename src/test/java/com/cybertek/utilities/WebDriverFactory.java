package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private WebDriverFactory(){}

    //task
    //write a static method that takes a string parameter name: browserType
    //base on the value of parameter
    //it will setup teh browser and
    //the methos will return chromedriver or firefoxdriver object
    //name of the method: getdriver

    public static WebDriver getDriver(String browserType){
        WebDriver driver;

        switch(browserType.toLowerCase()){
            case"chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case"firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                driver=null;
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }
}
