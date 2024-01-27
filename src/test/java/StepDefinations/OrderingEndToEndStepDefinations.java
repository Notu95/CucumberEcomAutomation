package StepDefinations;

import java.lang.reflect.Array;
import java.util.List;

import org.bouncycastle.util.Arrays;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AbstractComponents.AbstractComponents;
import pageobjects.*;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderingEndToEndStepDefinations {

	WebDriver driver ;
	ProductCatalogue pc;
	CartPage cp;
	PlaceOrderPage pp;
	ConfirmationPage cfp;
	
	@Given("browser is loaded")
	public  void browser_is_loaded() {
		System.out.println("Hi,Browser is loaded");
		String projectPath= System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver",
//				projectPath+"/src/test/resources/Drivers/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver",
//				"C:/Users/SOURAV/chrmDriver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
				
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Given("Application is loaded")
	public void user_is_on_login_page() {
		   driver.get("https://rahulshettyacademy.com/client/");
	}
	@When("^user enters (.*) and (.*)$")
	public void user_enters_user_name_and_password(String user,String pass) {
		LandingPage lp=new LandingPage(driver);
		pc=lp.loginApp(user, pass);
	  
	}

	
	@And("click on login button")
	public void click_on_login_button() {
		
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
	    boolean b=driver.getPageSource().contains("ZARA COAT 3");
	    System.out.println(b);
	    }
	
	@When("^user adds to cart the (.*)$")
	public void user_adds_to_cart_the_items(String item) {
		pc.getProductList();
		
	   pc.addToCart(item);
	}
	@And ("user click on cart icon")
	public void goingToCartPage() {
		AbstractComponents ac=new AbstractComponents(driver); 
		cp=ac.goToCart();
	}
	@And ("user clicks on check out button")
	public void checkingOut() {
		pp=cp.checkOut();
	}
	@And ("user fields mandatory fields and places order")
	public void placingOrder() throws InterruptedException {
		pp.selectCountry("ind");
		try {
			cfp=pp.placeOrder();
		} catch (InterruptedException e) {
			cfp=pp.placeOrder();
		}
	}
	@Then ("OrderId should be got")
	public void confirming()  {
		System.out.println(cfp.getOrderId()+"helllllllllloooooooo");
		Assert.assertFalse(cfp.getOrderId().isEmpty());  
	}
	
}
