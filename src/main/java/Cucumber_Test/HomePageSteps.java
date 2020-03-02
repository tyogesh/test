package Cucumber_Test;

import java.util.Random;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class HomePageSteps {
	HomePageObjects hp;
	BasePage bp;
	int random = new Random().nextInt(50000);
	String email = "abcd"+random+"@gmail.com";
	
	public  HomePageSteps()
	{
		bp= new HomePageObjects();
	}
	@Given("^User launch the application$")
	public void user_launch_the_application() throws Throwable {
		hp = new HomePageObjects();
	   
	}

	@When("^User enter email \"(.*?)\" in the subscription text box$")
	public void user_enter_email_in_the_subscription_text_box(String arg1) throws Throwable {
		hp.setNewsLetter(email);	    
	}

	@Then("^User should see subscription Message$")
	public void user_should_see_subscription_Message() throws Throwable {
		String result= hp.getNewsLetterMsg();
		org.junit.Assert.assertTrue("Failed", result.contains("successfully"));
		System.out.println(result);  
	}

	@When("^User Click on the tab \"(.*?)\"$")
	public void user_Click_on_the_tab(String arg1) throws Throwable {
	 if (arg1.equalsIgnoreCase("dresses")){
		 hp.clickDresses(); }
	 else if (arg1.equalsIgnoreCase("Women")){
		 
	 }
	 
	}

	@Then("^User should see the respective details page \"(.*?)\"$")
	public void user_should_see_the_respective_details_page(String arg1) throws Throwable {
	    org.junit.Assert.assertTrue(arg1.toLowerCase().contains(hp.getTitlte().toLowerCase()));
	}

	@Then("^User should see the same number of products count matching with the product header count displayed$")
	public void user_should_see_the_same_number_of_products_count_matching_with_the_product_header_count_displayed() throws Throwable {
		
		Assert.assertTrue("Failed:Count mismatched", hp.getProductCount()==hp.getProductCountFromHeader());
		System.out.println(hp.getProductCount());
		System.out.println(hp.getProductCountFromHeader());
	}

	@When("^the click on Add to cart button for the product \"(.*?)\"$")
	public void the_click_on_Add_to_cart_button_for_the_product(String arg1) throws Throwable {
		hp.moveToProduct();
	}

	@Then("^the product should added to cart page$")
	public void the_product_should_added_to_cart_page() throws Throwable {
		String msg=hp.getTxtCart();
		  Assert.assertTrue("Failed:Product not added to cart", msg.contains("successfully"));
		  hp.close();
	      
	}


}
