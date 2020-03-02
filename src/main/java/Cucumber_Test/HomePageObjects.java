package Cucumber_Test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends BasePage {
	
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement tabDresses;
	
	@FindBy(id = "newsletter-input")
	private WebElement txtBoxNewsLetter;
	
	@FindBy(name = "submitNewsletter")
	private WebElement txtBoxSubmitButton;
	
	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement msgSuccess;
	
	@FindBy(xpath = "(//*[text()='Women'])[2]")
	private WebElement tabWomen;
	
	@FindBy(xpath="//*[@class='heading-counter']")
	private WebElement txtProductHeaderCount;
	
	@FindBys(@FindBy(xpath = "//*[@class='product_list grid row']/li"))
	private List<WebElement> firstProduct;
	
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[5]/div/div[1]/div/a[1]/img")
	private WebElement productfive;

	@FindBy(xpath = "//*[@id='center_column']/ul/li[5]/div/div[2]/div[2]/a[1]/span")
	private WebElement addCart;
	
	@FindBy(tagName = "h2")
	private WebElement txtAddToCart;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/span")
	private WebElement close;
	
	public HomePageObjects(){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDresses() {
		return tabDresses;
	}

	public WebElement getWomen() {
		return tabWomen;
	}	
	
	public void clickDresses(){
		tabDresses.click();
		
	}	
	
	public void setNewsLetter(String email){
		setText(txtBoxNewsLetter, email);
		txtBoxSubmitButton.click();
	}
	
	public String getNewsLetterMsg(){
		return msgSuccess.getText();
	}	
	public int getProductCount()
	{
		return firstProduct.size();
	
	}
	
	public int getProductCountFromHeader()
	{
	 return Integer.parseInt(txtProductHeaderCount.getText().split(" ")[2]);
	}
	
	public String getTxtCart()
	{
		isElementVisible(txtAddToCart);
		return txtAddToCart.getText();
	}
	
	public void moveToProduct()
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(productfive).moveToElement(addCart).click().build().perform();
	}
	
	public void close()
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(close).click().build().perform();
	}
}




