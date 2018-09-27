package com.qa.PetClinic_spring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(xpath ="/html/body/app-root/div[1]/nav/div/ul/li[2]")
	WebElement owner;
	
	@FindBy(xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]")
	WebElement all; 
	
	
	
	public void click(WebDriver driver, String str) {
		owner.click();
		all.click();
	}
	
	

}
