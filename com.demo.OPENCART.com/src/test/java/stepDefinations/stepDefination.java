package stepDefinations;

import java.io.File;
import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import OPENCART.Login;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.base;

public class stepDefination extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());

	@Before
	public void setUP() {
		System.out.println("launch chrome");
	}

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = intializeDriver();
		log.info("browser launch");
	}

	@Then("^click signin$")
	public void click_signin() throws Throwable {
		Login l = new Login(driver);
		Actions act = new Actions(driver);
		act.moveToElement(l.getaccount()).build().perform();
		l.getaccount().click();
		
		// 1.Test case-->Register user

		l.getregister().click();
		File src = new File("C:\\Execldata\\jeevanh5.xlsx");
		FileInputStream input = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		String fname = sheet.getRow(1).getCell(0).getStringCellValue();
		l.getfname().sendKeys(fname);

		String lname = sheet.getRow(1).getCell(1).getStringCellValue();
		l.getlname().sendKeys(lname);
		String email = sheet.getRow(1).getCell(2).getStringCellValue();
		l.getemil().sendKeys(email);
		// int tele=(int)sheet.getRow(1).getCell(3).getNumericCellValue();
		// l.getnumber().sendKeys(tele);
		l.getnumber().sendKeys("8660725304");
		String pass = sheet.getRow(1).getCell(4).getStringCellValue();
		l.getpass().sendKeys(pass);
		String confirmpass = sheet.getRow(1).getCell(5).getStringCellValue();
		l.getconfpass().sendKeys(confirmpass);

		l.getradio().click();
		l.getchk().click();
		l.getcontionue().click();
		l.getcontbtn().click();
		
		String title = driver.getTitle();
		System.out.println(title);
		log.info("Title of we page" + title);
		
		//4.login
				l.getaccount().click();
				l.getlogin().click();
				File src1 = new File("C:\\Execldata\\jeevanh5.xlsx");
				FileInputStream input1 = new FileInputStream(src1);
				XSSFWorkbook wb1 = new XSSFWorkbook(input1);
				XSSFSheet sheet1 = wb1.getSheet("Sheet1");
				String email1 = sheet1.getRow(1).getCell(2).getStringCellValue();
				l.getemil().sendKeys(email1);
				String pass1 = sheet1.getRow(1).getCell(4).getStringCellValue();
				l.getpass().sendKeys(pass1);
				l.getloginbtn().click();
				
				
				//5.test case
				act.moveToElement(l.getdekstops()).build().perform();
				l.getdekstops().click();
				l.getmac1().click();
				l.getimac().click();
				l.getaddtocart().click();
				
				String msg=l.getsuccessmsg().getText();
				log.info(msg);
				File src11=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); try
				  { 
					FileHandler.copy(src11, new File(
				 "C:\\testhackathon\\com.demo.opencart.com\\report\\snap.png"));
				  
				  } 
				catch (Exception e) { e.printStackTrace(); 
				  } 
				
	}

	@And("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {

		File src = new File("C:\\\\Execldata\\\\jeevanh5.xlsx");
		FileInputStream input = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		String url = sheet.getRow(1).getCell(6).getStringCellValue();
		driver.get(url);
		wb.close();
	}
	
	 @Then("^order with resiter user$")
	    public void order_with_resiter_user() throws Throwable
	    {
		   Login l=new Login(driver);
		   l.getlaptops().click();
		   l.getmore().click();
		   l.gethp().click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,1000)");
		     
		     l.getdate().sendKeys("2021-07-16");
		     l.getaddtocart2().click();
		     l.getbasket().click();
		     
		     JavascriptExecutor js1 = (JavascriptExecutor) driver;
		     js1.executeScript("window.scrollBy(0,1000)");
		     l.getcheckout2().click();
		     Thread.sleep(3000);
		     l.getradio5().click();
		     l.getcontinue3().click();
		     
		     
		    File src1 = new File("C:\\Execldata\\jeevanh5.xlsx");
				FileInputStream input1 = new FileInputStream(src1);
				XSSFWorkbook wb1 = new XSSFWorkbook(input1);
				XSSFSheet sheet2 = wb1.getSheet("Sheet2");
				
				
				String getfname2 = sheet2.getRow(1).getCell(0).getStringCellValue();
				l.getfname2().sendKeys(getfname2);
				
				String getlname2 = sheet2.getRow(1).getCell(1).getStringCellValue();
				l.getlname2().sendKeys(getlname2);
				
				String getemail2 = sheet2.getRow(1).getCell(2).getStringCellValue();
				l.getemail2().sendKeys(getemail2);
				l.getloginbtn().click();
				
				//String  gettelephone2=(String)sheet2.getRow(1).getCell(3).getStringCellValue();
				//l.gettelephone2().sendKeys(gettelephone2);
				
				String  getpass2=(String)sheet2.getRow(1).getCell(4).getStringCellValue();
				l.getpass2().sendKeys(getpass2);
				
				String  getpass3=(String)sheet2.getRow(1).getCell(5).getStringCellValue();
				l.getpass3().sendKeys(getpass3);
				
				String  getaddress=(String)sheet2.getRow(1).getCell(6).getStringCellValue();
				l.getaddress().sendKeys(getaddress);
				
				String  getcity=(String)sheet2.getRow(1).getCell(7).getStringCellValue();
				l.getcity().sendKeys(getcity);
				
				String  getpostal=(String)sheet2.getRow(1).getCell(7).getStringCellValue();
				l.getpostal().sendKeys(getpostal);
				
				
		     
		   l.getfname2().sendKeys("Jeevan");
		    l.getlname2().sendKeys("bhadra");
		   l.getemail2().sendKeys("jeevanbhadra24@gmail.com");
				
		    l.gettelephone2().sendKeys("8660725304");
		     l.getpass2().sendKeys("testing@1234");
		    l.getpass3().sendKeys("testing@1234");
		     l.getaddress().sendKeys("Chikkalsandra");
		     l.getcity().sendKeys("Bengaluru");
		     l.getpostal().sendKeys("560061");
		     
		     Select select=new Select(l.getcountry());
		     select.selectByVisibleText("India");
		     
		     Select select2=new Select(l.getstate());
		     select2.selectByVisibleText("Karnataka");
		     
		     Thread.sleep(3000);
		     
		     driver.findElement(By.xpath("//*[@id='collapse-payment-address']/div/div[4]/div/input[1]")).click();
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[4]/div/input[2]")).click();
		    //driver.findElement(By.xpath("//input[contains(@id='button-register')]")).click();
		     
		   //  /html/body/div[2]/div/div/div/div[2]/div[2]/div/div[4]/div/input[2]
		     
		    // driver.findElement(By.xpath("//*[@id='button-register']")).click();
		     
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("//*[@id='button-shipping-address']")).click();;
		     l.getdelevery().sendKeys("hello Jeevan");
		     l.getcont5().click();
		     
		     Thread.sleep(3000);
		     l.getterms().click();
		     l.getcont6().click();
		     Thread.sleep(3000);
		     l.getconfrimorder().click();
		     
		   
	    }

	 
	 @Then("^upload file$")
	    public void upload_file() throws Throwable 
	    {
		 Login l=new Login(driver);
		 l.getcomponent().click();
		 l.getmonitors().click();
		 l.getapple().click();
		 Thread.sleep(3000);
		 l.getcheckbox4().click();
		 l.gettext().sendKeys("Testing");
		  
		Select select=new Select(l.getselect());
		select.selectByVisibleText("Green(+$1.00)");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollBy(0,500)");
		l.getarea().sendKeys("testing");
		l.getfileupload().sendKeys("C:\\Execldata\\jeevanh5.xlsx");
		Thread.sleep(3000);
		l.getaddtocat().click();
		
	    }
	 
	 @Then("^update account$")
	    public void update_account() throws Throwable 
	    {
		 
		 Login l=new Login(driver);
		 Actions act=new Actions(driver);
		 act.moveToElement(l.getaccount()).build().perform();
	     l.getlogin().click();
		 File src = new File("C:\\Execldata\\jeevanh5.xlsx");
		 FileInputStream input = new FileInputStream(src);
		 XSSFWorkbook wb = new XSSFWorkbook(input);
		 XSSFSheet sheet = wb.getSheet("Sheet1");
		 String email = sheet.getRow(1).getCell(2).getStringCellValue();
		 l.getemil().sendKeys(email);
		 String pass = sheet.getRow(1).getCell(4).getStringCellValue();
		 l.getpass().sendKeys(pass);
		 l.getloginbtn().click();
			
		 Thread.sleep(3000);
		 l.geteditaccount().click();
     Thread.sleep(3000);
	     l.getcont7().click();
	     
	     JavascriptExecutor js2 = (JavascriptExecutor) driver;
	     js2.executeScript("window.scrollBy(0,1000)");
	     l.getlog2().click();
	     driver.navigate().back();
	      
	    }
	 
	 
	 	/*
	 * @After(order=1) public void tearDown(){ driver.close();
	 * System.out.println("close the browser"); }
	 */

	









}




	/*@Then("^capture error msg$")
	public void capture_error_msg() throws Throwable {
	    
	}*/
	



