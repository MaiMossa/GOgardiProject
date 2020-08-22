package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Pagebase {

	JavascriptExecutor js = (JavascriptExecutor)driver;	

	public RegisterPage(WebDriver driver) {

		super(driver);

	}





	@FindBy(xpath ="//div/div[1]/div[1]/h3")
	public WebElement RegisterForm;

	@FindBy(xpath ="//div/div/div[1]/form/div[1]/input")
	public WebElement Firstname;

	@FindBy(xpath ="//div/div/div[1]/form/div[2]/input")
	public WebElement Secondname;

	@FindBy(xpath ="//div/div/div[1]/form/div[3]/input")
	public WebElement Email;

	@FindBy(xpath ="//div/div/div[1]/form/div[4]/div[1]/div/input")
	public WebElement Password;



	@FindBy(xpath ="//div/div/div[1]/form/div[1]/span")
	public WebElement FirstnameVerification;

	@FindBy(xpath ="//div/div/div[1]/form/div[2]/span")
	public WebElement SecondnameVerification;

	@FindBy(xpath ="//div/div/div[1]/form/div[3]/span")
	public WebElement EmailVerification;

	@FindBy(xpath ="//div/div/div[1]/form/div[4]/div[1]/span")
	public WebElement PasswordVerification;




	@FindBy(id ="checkbox1")
	public WebElement checkbox1;

	@FindBy(id = "checkbox2")
	public WebElement checkbox2;


	@FindBy(xpath ="/html/body/div[2]/div[3]/div[1]/div/div/span")
	public WebElement checkBoxfornotRobot;

	@FindBy(linkText="Register")
	public WebElement RegisterButtont;

	@FindBy(xpath ="/html/body/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div/div[1]/form/div[4]/div[1]/div/div/div")
	public WebElement passwordShowIcon;

	@FindBy(xpath  ="//div/div/div[1]/form/div[4]/div[2]/div[2]/span")
	public WebElement passwordStatus;


	public boolean RegisterFormVerification() {
		boolean condition = false;

		if(RegisterForm.getText().trim().contains("Join GOcardi!")){
			condition=true;
		}
		return condition;

	}


	public void EnsertData (String FirstNametxt, String LastNametxt , String Emailtxt, String Passwordtxt) {

		EnterText(Firstname,FirstNametxt);
		EnterText(Secondname,LastNametxt);
		EnterText(Email,Emailtxt);
		EnterText(Password,Passwordtxt);


	}

	public void Click_CheckBox1 (){

		Click_Button(checkbox1);

	}

	public void Click_CheckBox2 (){

		Click_Button(checkbox2);

	}

	public void Click_CheckBoxfornotRobot (){

		WebElement iFrame = driver.findElement(By.xpath("//*[@id=\"rc-anchor-container\"]"));
		driver.switchTo().frame(iFrame);
		WebElement iFrame_checkbox = 
				driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
		iFrame_checkbox.click();

	}



	public void Click_passwordShowIcon (){



		if(passwordShowIcon.getText().trim().contains("show")) {

			Click_Button(passwordShowIcon);
		}
	}

	public String TypeofPassword () {

		String type ="";
		type = Password.getAttribute("type");
		return type;
	}

	// using Action interface  to move to element 
	public void Click_Register_Button (){

		//Actions action= new Actions(driver);
		//action.moveToElement(RegisterButtont).click().build().perform();

		Click_Button(RegisterButtont);

	}



	public boolean  VerifyRegisterButtonIsDisabled() {
		boolean condition = false;

		//Actions action= new Actions(driver);

		//action.moveToElement(RegisterButtont).build().perform();

		//js.executeScript("arguments[0].scrollIntoView(true);", RegisterButtont);

		condition = RegisterButtont.getAttribute("type").equals("disabled");


		return condition;

	}



	public boolean FirstnameFieldVerification() {
		boolean condition = false;

		if(FirstnameVerification.getText().trim().contains("You can enter letters only in this field.")||FirstnameVerification.getText().trim().contains("Please enter 2 characters at least.")){
			condition=true;
		}
		return condition;

	}

	public boolean SecondnameFieldVerification() {
		boolean condition = false;

		if(SecondnameVerification.getText().trim().contains("You can enter letters only in this field.")||SecondnameVerification.getText().trim().contains("Please enter 2 characters at least.")){
			condition=true;
		}

		return condition;
	}
	public boolean EmailFieldVerification() {

		boolean condition = false;

		if(EmailVerification.getText().trim().contains("Please enter a valid email address.")){
			condition=true;
		}

		return condition;
	}
	public boolean PasswordFieldVerification() { 
		boolean condition = false;
		if(PasswordVerification.getText().trim().contains("Your password must be at least 8 characters long.")||PasswordVerification.getText().trim().contains("Your password must be 20 characters long maximum.")){
			condition=true;
		}
		return condition;
	}

	public boolean PasswordStatusText() { 
		boolean condition = false;
		if(passwordStatus.getText().trim().contains("Very Weak")||passwordStatus.getText().trim().contains("Medium")||passwordStatus.getText().trim().contains("Strong")||passwordStatus.getText().trim().contains("Very Strong")){
			condition=true;
		}
		return condition;
	}



}
