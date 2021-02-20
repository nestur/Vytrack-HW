package com.cybertek.test;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.TestBase;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HW1 extends TestBase {

    @BeforeClass
    private void login(){
        new LoginPage().loginAsStoreManager();
    }

    @BeforeMethod
    private void goToCalenderEvents(){
        new DashboardPage().navigateToModule("Activities","Calendar Events");
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
    }

    @Test
    public void test1() {
        WebElement options = driver.findElement(By.xpath("//div[@class='btn-group actions-group']/div[1]"));
        Assert.assertTrue(options.isDisplayed(), "Options is NOT displayed!");
    }

    @Test
    public void test2() {
        WebElement numberPage= driver.findElement(By.xpath("//input[@type= 'number']"));
        Assert.assertEquals(numberPage.getAttribute("value"),"1","Page number is not 1");
    }

    @Test
    public void test3() {
        WebElement viewPerPage = driver.findElement(By.xpath("//div[@class='btn-group']/button"));

        //Wait for element to go stale once.
        new WebDriverWait(driver, 5).until(ExpectedConditions.stalenessOf(viewPerPage));
        viewPerPage = driver.findElement(By.xpath("//div[@class='btn-group']/button"));

        Assert.assertTrue(viewPerPage.getText().contains("25"),"View per page number is NOT 25 ");
    }
    @Test
    public void test4(){
        WebElement viewPerPage = driver.findElement(By.xpath("//div[@class='btn-group']/button"));

        //Wait for element to go stale once.
        new WebDriverWait(driver, 5).until(ExpectedConditions.stalenessOf(viewPerPage));

        int viewRowsPerPage = Integer.parseInt(driver.findElement(By.xpath("//div[@class='btn-group']/button")).getText());
        int totalPageRows= Integer.parseInt(driver.findElement(By.xpath("//div[@class='pagination pagination-centered']/label[2]")).getText());
        WebElement pageNumberInput = driver.findElement(By.xpath("//input[@type='number']"));
        pageNumberInput.sendKeys(String.valueOf(totalPageRows) + Keys.RETURN);

        int allRowsNumber = (totalPageRows-1) * viewRowsPerPage +
                List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//div[@id='grid-calendar-event-grid-1775598516']//tr"));
        System.out.println(allRowsWithHeader.size());
    }

}