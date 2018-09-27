package com.qa.PetClinic_spring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnersPage {
	
	@FindBy(xpath="/html/body/app-root/app-owner-list/div/div/div/div/button")
	WebElement add; 

	@FindBy(xpath="//*[@id=\"firstName\"]")
	WebElement firstname; 
	
	@FindBy(xpath="//*[@id=\"lastName\"]")
	WebElement last;
	
	@FindBy(xpath="//*[@id=\"address\"]")
	WebElement address;
	
	@FindBy(xpath="//*[@id=\"city\"]")
	WebElement city;
	
	@FindBy(xpath="//*[@id=\"telephone\"]")
	WebElement phone;
	
	@FindBy(xpath ="/html/body/app-root/div[1]/nav/div/ul/li[2]")
	WebElement owner;
	
	@FindBy(xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]")
	WebElement all; 
	
	@FindBy(xpath="/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	WebElement sub;
	
	
	
	public void click(WebDriver driver, String str) {
		owner.click();
		all.click();
	}
	
	public void addOwner(String name, String Lname, String addr, String cit, String Phon) throws InterruptedException {
		
		add.click();		
		Thread.sleep(2000); 		
		firstname.sendKeys(name);
		last.sendKeys(Lname);
		address.sendKeys(addr);
		city.sendKeys(cit);
		phone.sendKeys(Phon);
		
		sub.submit();
		 Thread.sleep(2000);
		
	}
	
	public void select(WebDriver driver, String str) throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement name = driver.findElement(By.linkText(str));
		name.click();
		
		Thread.sleep(2000);
		
	}

	
}
