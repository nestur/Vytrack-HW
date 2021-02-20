package com.cybertek.pages;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// we can create logins and preconditions here
public class LoginPage {

    public LoginPage(){ //constructor
        PageFactory.initElements(Driver.get(),this);
    }
    // a selenium class
    // Driver.get() which is browser we use // this means the webelement we use
    //accepts two parameters and says execute the @FindBy
    // Interview: just say In my framework I have a loginPage which has PageFactory class belongs to Selenium and
    // I use initElements to connect Browser and WebElement

    // without PageFactory we cannot use
    // () you can choose different when open the parenthesis

    //driver.findElement(By.id("prependedInput"));
    //we can find more than one webElement and its condition is "or"

    @FindAll({
            @FindBy(id = "prependedInput"),
            @FindBy(name ="_username")
    })
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //driver.findElement(By.id("_submit"));
    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsDriver(){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsSalesManager() {

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}