package com.cybertek.pages;

import org.testng.annotations.BeforeMethod;

public class DashboardPage extends BasePage{
    //no need to explicitly write constructor, because it will use its parents constructor
    @BeforeMethod
    public static void deneme(){
        System.out.println("hello");
        //deniyoruz
    }

}