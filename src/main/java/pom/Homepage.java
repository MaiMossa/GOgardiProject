package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends Pagebase {

	

	public Homepage(WebDriver driver) {
		super(driver);
	}


	@FindBy(linkText ="Register")
	public WebElement ele_register;

	@FindBy(linkText = "English")
	public WebElement ClickEnglishtab;
	
	public void Click_Register_Link (){
		
		Click_Button(ele_register);

	}
	
public void Convert_to_English (){
		
	if(ClickEnglishtab.getText().trim().contains("English")) {
		
		Click_Button(ClickEnglishtab);
	
	}
	
}





}
