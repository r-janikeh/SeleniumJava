package PensionFundRats;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class VerifyPensionFund {
	public WebDriver driver = null;

	
@BeforeTest
	public void SetupTest()
	{
	driver= new ChromeDriver();
	}

@Test (priority=1)
public  void PensionStartSaving() throws InterruptedException {
	
	//TC1
	
	driver.get("https://www.swedbank.ee/private?language=ENG");
	driver.manage().window().maximize();
	
	//handle cookies
	driver.findElement(By.xpath("//*[@id=\"cookies-info-block\"]/div/div[1]/div[2]/button[2]")).click();
	Thread.sleep(2000);
	
	//open 'Pension' section and click on the 'III pillar - What is III pillar?'
	driver.findElement(By.xpath("//*[@id=\"private.pensions\"]/span")).click();
	driver.findElement(By.xpath("//*[@id=\"private.pensions.pillar3.description\"]/span")).click();
	Thread.sleep(3000);

	//scroll page and click on the "Start saving"
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	WebElement Element1 = driver.findElement(By.linkText("Start saving"));
	js1.executeScript("arguments[0].scrollIntoView();", Element1);
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[@id=\"p3_calc\"]/div/div/div[2]/div/a")).click();
	Thread.sleep(3000);
	
	//click on the "Choose V-fund"
	driver.findElement(By.xpath("//*[@id=\"p3InvestmentsHead\"]/div/table/tfoot/tr/td[2]/p[1]/a")).click();
	Thread.sleep(3000);
	
	//scroll page and click on the "Start saving"
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	WebElement Element2 = driver.findElement(By.linkText("Start saving"));
	js2.executeScript("arguments[0].scrollIntoView();", Element2);
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[@id=\"mainForm\"]/section[3]/div/div[2]/a[2]")).click();
	Thread.sleep(3000);
	
	//enter TC1 in the 'User ID' field and click on "Enter" button
	driver.findElement(By.xpath("//*[@id=\"userId\"]")).sendKeys("TC1");
	Thread.sleep(3000);
	driver.findElement(By.id("pwdLoginButton")).submit();
	Thread.sleep(3000);
	
	//check the invalid error message
	String Act_meesageTC1 = driver.findElement(By.xpath("//*[@id=\"loginErrorMessage\"]/div")).getText();
	String Exp_meesageTC1 = "Incorrect password/code/user ID! Please try again! If you enter invalid credentials for 5 consecutive times, your access to Internet Banking will be blocked. See the instruction if you’re repeatedly unable to log in to Internet Banking.";
	System.out.println("TC1_Result: " +Act_meesageTC1);
	if (Act_meesageTC1.equals(Exp_meesageTC1))
	{
		System.out.println("Message passed");
	}
	else
	{
		System.out.println("Message failed");
	}
	
	Thread.sleep(3000);		
}

@Test (priority=2)
public  void PensionStartSavingMessage() throws InterruptedException  {
	

	//TC2
	
	//open 'Pension' section and click on the 'III pillar - What is III pillar?'
	driver.findElement(By.xpath("//*[@id=\"private.pensions\"]/span")).click();
	driver.findElement(By.xpath("//*[@id=\"private.pensions.pillar3.description\"]/span")).click();
	Thread.sleep(3000);

	//scroll page and click on the "Start saving"
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	WebElement Element3 = driver.findElement(By.linkText("Start saving"));
	js3.executeScript("arguments[0].scrollIntoView();", Element3);
	Thread.sleep(3000);
	
	//click on the "Enter into agreement"
	driver.findElement(By.xpath("//*[@id=\"p3InvestmentsHead\"]/div/table/tfoot/tr/td[1]/p[1]/a")).click();
	Thread.sleep(2000);
	
	//enter TC1 in the 'User ID' field and click on "Enter" button
	driver.findElement(By.id("userId")).sendKeys("TC2");
	driver.findElement(By.id("pwdLoginButton")).submit();
	Thread.sleep(2000);
	
	//check the invalid error message
	String Act_meesageTC2 = driver.findElement(By.xpath("//*[@id=\"loginErrorMessage\"]/div")).getText();
	String Exp_meesageTC2 = "Incorrect password/code/user ID! Please try again! If you enter invalid credentials for 5 consecutive times, your access to Internet Banking will be blocked. See the instruction if you’re repeatedly unable to log in to Internet Banking.";
	System.out.println("TC2_Result: " +Act_meesageTC2);
	
	if (Act_meesageTC2.equals(Exp_meesageTC2))
	{
		System.out.println("Message passed");
	}
	else
	{
		System.out.println("Message failed");
	}
}



@Test (priority=3)
	public void PensionFundPage1() throws InterruptedException
	{
	
	//open the 'Pension' section and click on the 'Pension fund rates'
	driver.findElement(By.xpath("//*[@id=\"private.pensions\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"private.pensions.pillar3.allFunds\"]/span")).click();
	Thread.sleep(3000);

	//click on the 'Long term annualized performance' tab and check that text 'Long term return' is shown.
	driver.findElement(By.xpath("//*[@id=\"Tab2\"]/a/span")).click();
	Thread.sleep(2000);
	String Act_ReturnText= driver.findElement(By.xpath("//*[@id=\"fundList\"]/table[1]/thead/tr[1]/th[5]")).getText();
	String Exp_ReturnText = "Long term return";
	boolean t1 = (Act_ReturnText.equals(Exp_ReturnText));
	String result1 = (t1==true) ? "Tab 2 -- Passed"  : "Tab 2 -- Failed";
	System.out.println("Result is: "+result1);
	Thread.sleep(3000);
	
	//click on the 'Long term cumulative performance' tab and check that text 'Long term cumulative return' is shown.
	driver.findElement(By.xpath("//*[@id=\"Tab3\"]/a/span")).click();
	Thread.sleep(2000);
	String Act_ReturnCumuText= driver.findElement(By.xpath("//*[@id=\"fundList\"]/table[1]/thead/tr[1]/th[5]")).getText();
	String Exp_ReturnCumuText = "Long term cumulative return";
	boolean t2= (Act_ReturnCumuText.equals(Exp_ReturnCumuText));
	//Assert.assertTrue("Tab 3 -- Passed", t2);
	String result2 = (t2==true) ? "Tab 3 -- Passed"  : "Tab 3 -- Failed";
	System.out.println("Result is:"+result2);
	Thread.sleep(3000);
	
	//click on the 'Risk statistics' tab and check that text 'Standard deviation' is shown.
	driver.findElement(By.xpath("//*[@id=\"Tab4\"]/a/span")).click();
	Thread.sleep(2000);
	String Act_StandardText= driver.findElement(By.xpath("//*[@id=\"fundList\"]/table[1]/thead/tr/th[3]")).getText();
	String Exp_StandardText = "Standard deviation";
	boolean t3= (Act_StandardText.equals(Exp_StandardText));
	String result3 = (t3==true) ? "Tab 4 -- Passed"  : "Tab 4 -- Failed";
	System.out.println("Result is:"+result3);
	Thread.sleep(3000);
	
	//click on the 'Short term performance' tab and check that text 'Short term returns' is shown.
	driver.findElement(By.xpath("//*[@id=\"Tab1\"]/a/span")).click();
	Thread.sleep(2000);
	String Act_PerfText= driver.findElement(By.xpath("//*[@id=\"fundList\"]/table[1]/thead/tr[1]/th[6]")).getText();
	String Exp_PerfText = "Short term returns";
	boolean t4= (Act_PerfText.equals(Exp_PerfText));
	String result4 = (t4==true) ? "Tab 1 -- Passed"  : "Tab 1 -- Failed";
	System.out.println("Result is:"+result4);
	Thread.sleep(3000);
	}

	//TC2
	@Test (priority=4)
	public void PensionFundPage2() throws InterruptedException {
	
	driver.findElement(By.xpath("//*[@id=\"tableRow3\"]/td[2]/a")).click();
		Thread.sleep(3000);

	JavascriptExecutor js4 = (JavascriptExecutor) driver;
	Thread.sleep(3000);
	WebElement Element4 = driver.findElement(By.xpath("//*[@id=\"Tab3\"]/a/span"));
	Thread.sleep(3000);
	
	js4.executeScript("arguments[0].scrollIntoView();", Element4);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"Tab3\"]/a/span")).click();
	Thread.sleep(3000);
	
	JavascriptExecutor js5 = (JavascriptExecutor) driver;
	WebElement Element5 = driver.findElement(By.xpath("//*[@id=\"mainForm\"]/section[3]/p/a"));
	js5.executeScript("arguments[0].scrollIntoView();", Element5);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"mainForm\"]/section[3]/p/a")).click();
	Thread.sleep(3000);
	
	
	
	//find the dropdown using xpath and check the "FUND" Value
	WebElement dropdownElement1 = driver.findElement(By.xpath("//*[@id=\"mainForm\"]/section/ui-field[1]/div[2]/select"));
	Select dropdown1 = new Select(dropdownElement1);
	dropdown1.selectByValue("FUND");
	String SelectedrNot1 = dropdownElement1.getTagName();
	System.out.println(" FUND  : "+SelectedrNot1);
	
	//find the dropdown using xpath and check the "EUR" Value
	WebElement dropdownElement2 = driver.findElement(By.xpath("//*[@id=\"mainForm\"]/section/ui-field[2]/div[2]/select"));
	Select dropdown2 = new Select(dropdownElement2);
	dropdown2.selectByValue("EUR");
	String SelectedrNot2 = dropdownElement2.getTagName();
	System.out.println(" EUR : "+SelectedrNot2);	
	
	//find the dropdown using xpath and check the "SWEDBANK PENSIONIFOND K60" Value
	WebElement dropdownElement3 = driver.findElement(By.xpath("//*[@id=\"mainForm\"]/section/ui-field[3]/div[2]/select"));
	Select dropdown3 = new Select(dropdownElement3);
	dropdown3.selectByValue("HANSAP2S-K3");  //SWEDBANK PENSIONIFOND K60
	String SelectedrNot3 = dropdownElement2.getTagName();
	System.out.println(" SWEDBANK PENSIONIFOND K60 : "+SelectedrNot3);	
	}
	
	@AfterTest
	public  void FinishTest()
	{
	  driver.close();
	  driver.quit();

	}

}
