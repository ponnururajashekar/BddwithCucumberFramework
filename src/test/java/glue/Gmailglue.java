package glue;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;

public class Gmailglue 
{
public WebDriver driver;
public WebDriverWait wait;
public Scenario s;
public Properties p;
public Homepage hp;
public Loginpage lp;
public Composepage cp;

@Before
public void method1(Scenario s) throws Exception
{
	this.s=s;
	FileInputStream fi = new FileInputStream("D:\\WorkSpace\\BDDWithCucumberFramework\\src\\test\\resources\\repository\\file1.properties");
	p=new Properties();
	p.load(fi);
}

@Given("^launch site$")
public void method2()
{
	System.setProperty("webdriver.chrome.driver", p.getProperty("cdpath"));
	driver=new ChromeDriver();
	hp=new Homepage(driver);
	lp=new Loginpage(driver);
	cp=new Composepage(driver);
	driver.get(p.getProperty("url"));
	wait=new WebDriverWait(driver,20);
	driver.manage().window().maximize();
	
}

@Then("^title will be \"(.*)\" for home page$")
public void method3(String x)
{
	String t=driver.getTitle();
	if(t.equals(x))
	{
		s.write("Gmail site title test passed");
	}
	else 
	{
		byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(b, "Gmail site title test failed");
	}
}
@When("^close site$")
public void method4()
{
	driver.close();
}
@When("^enter userid like \"(.*)\" value$")
public void method5(String x)
{
	wait.until(ExpectedConditions.visibilityOf(hp.uid));
	hp.filluid(x);
}
@And("^click userid next button$")
public void method6()
{
	wait.until(ExpectedConditions.visibilityOf(hp.uidnext));
	hp.uidclicknext();
}
@Then("^validate userid output for \"(.*)\" with \"(.*)\" criteria$")
public void method7(String x,String y) throws Exception
{
	try 
	{	
	Thread.sleep(5000);
	
	if(x.length()==0 && hp.uidblankerr.isDisplayed())
	{
		s.write("UID blank value test passed");
	}
	
	else if(y.equalsIgnoreCase("invalid") && hp.uidinvaliderr.isDisplayed())
	{
		s.write("UID invalid value test passed");
	}
	else if(y.equalsIgnoreCase("valid") && lp.pwd.isDisplayed())
	{
		s.write("UID valid value test passed");
	}
	else
	{
		byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(b, "UID  test was  failed");
	}
    }catch(Exception ex) 
	{
	s.write(ex.getMessage());
    }
}
@When("^enter password like \"(.*)\" value$")
public void method8(String x)
{
	wait.until(ExpectedConditions.visibilityOf(lp.pwd));
    lp.fillpwd(x);
}
@And("^click password next button$")
public void method9()
{
	wait.until(ExpectedConditions.visibilityOf(lp.pwdnext));
	lp.pwdclicknext();
}
@Then("^Validate password output for \"(.*)\" with \"(.*)\" criteria")
public void method10(String x,String y) throws Exception
{
	try 
	{	
	Thread.sleep(5000);
	if(x.length()==0 && lp.pwdblankerr.isDisplayed())
	{
		s.write("Password blank value test passed");
	}
	else if(y.equalsIgnoreCase("invalid") && lp.pwddinvaliderr.isDisplayed())
	{
		s.write("Password invalid value test passed");
	}
	else if(y.equalsIgnoreCase("valid") && cp.comp.isDisplayed())
	{
		s.write("Password valid value test passed");
	}
	else
	{
		byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(b, "Password  test was  failed");
	}
    }catch(Exception ex) 
	{
	s.write(ex.getMessage());
    }
}
}
