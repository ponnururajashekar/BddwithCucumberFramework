package tests;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"D:\\WorkSpace\\BDDWithCucumberFramework\\src\\test\\resources\\features\\feature1.feature","D:\\WorkSpace\\BDDWithCucumberFramework\\src\\test\\resources\\features\\feature2.feature"},
	                            glue= {"classpath:glue"},
	                            monochrome=true,
	                            plugin= {"pretty","html:target\\result6"})
	
	public class GmailRunner1 
	{

}
