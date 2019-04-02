package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"D:\\WorkSpace\\BDDWithCucumberFramework\\src\\test\\resources\\features\\feature1.feature","D:\\WorkSpace\\BDDWithCucumberFramework\\src\\test\\resources\\features\\feature2.feature"},
                  plugin= {"pretty","html:\\target\\result1", "rerun:target\\failed.txt"})
                 
public class GmailFailedRunner1 {

}
