package testcase;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.AssertJUnit;

import pom.Homepage;

import pom.RegisterPage;

@Test
public class RgisterTestCase extends TestBase {

	Homepage homePage;

	RegisterPage registerPage;

	// Check the registration page in English way 

	public void RegistraionVerfifcation() throws IOException, InterruptedException {


		homePage = new Homepage(driver);

		registerPage = new RegisterPage(driver);


		homePage.Convert_to_English();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		homePage.Click_Register_Link();


		//get data from excel file 

		String TheFilePath = System.getProperty("user.dir") + "/src/test/java/data/TestData.xlsx";

		File theSourceFile = new File(TheFilePath);

		FileInputStream files = new FileInputStream(theSourceFile);


		XSSFWorkbook Wbook = new XSSFWorkbook(files);

		XSSFSheet sheet= Wbook.getSheetAt(0);

		int Rows =(sheet.getLastRowNum()+1);



		for (int i = 0; i < Rows; i++) {




			XSSFRow row= sheet.getRow(i); 

			// Get data
			String FirstName = row.getCell(0).toString();

			String SecondtName=row.getCell(1).toString(); 
			String Email=row.getCell(2).toString();
			String Password=row.getCell(3).toString();


			Boolean TheRegisterFormisApeared = registerPage.RegisterFormVerification();

			if(TheRegisterFormisApeared) {
				System.out.println("the register form page open successfully!"); } 
			else {
				System.out.println("the register form page not open"); 
			} 



			Boolean RegisterButtonIsDisabled =
					registerPage.VerifyRegisterButtonIsDisabled();

			if(RegisterButtonIsDisabled) { 
				System.out.println(" Register Button is disabled when no data inserted!"); 
			} else 
			{ System.out.println(" Register Button is submitted although  no data inserted!");  }

			registerPage.EnsertData(FirstName,SecondtName,Email,Password);


			Boolean FirstnameFieldisMandatory =registerPage.FirstnameFieldVerification();

			if(FirstnameFieldisMandatory) 
			{System.out.println("Verify FirstnameField is mandatory field! "); } 

			Boolean SecondnameFieldisMandatory =registerPage.SecondnameFieldVerification();

			if(SecondnameFieldisMandatory) {

				System.out.println(" Verify SecondnameField is mandatory field!"); }

			Boolean EmailFieldisMandatory =registerPage.EmailFieldVerification();
			if(EmailFieldisMandatory) {
				System.out.println(" Verify EmailField is mandatory field!"); } 

			Boolean PasswordFieldisMandatory =registerPage.PasswordFieldVerification();

			if(PasswordFieldisMandatory) {
				System.out.println(" Verify PasswordField is mandatory field!"); } 


			registerPage.Click_passwordShowIcon();

			String  PasswordTypeIs = registerPage.TypeofPassword();


			AssertJUnit.assertTrue(PasswordTypeIs.equals("text"));



			Boolean PasswordFieldStautsisAppeared =registerPage.PasswordStatusText();


			if(PasswordFieldStautsisAppeared) {
				System.out.println(" Verify Password Field Status is Appear clearly!"); } 
			else {
				System.out.println("Password Field Status is not Appear!"); 
			}


			registerPage.Click_CheckBox1(); 

			registerPage.Click_CheckBox2(); 



			if(!RegisterButtonIsDisabled) {
				registerPage.Click_Register_Button();
				System.out.println("Registered successfully:)");
			}


			// Take Screenshot for each inserting excel row on UI

			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			File DestFileDestFile = new File(System.getProperty("user.dir")+"/screenshots/gogardiscreen"+i+".png");

			FileUtils.copyFile(SrcFile, DestFileDestFile);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


			System.out.println(
					"--------------------------------"+"The Excel Row :"+i+"---------------------------------------------------"
					);



		}




		Wbook.close();
	}





}


