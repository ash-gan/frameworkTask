package steps.WebApp;

import utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

//    @Before
//    public void start(){
//        openBrowserAndLaunchApplication();
//    }

    @After
    //this executes always at the end irrespective of the result
    public void end(Scenario scenario){
        byte[] pic;
        //take the screenshot before closing the browser
        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }
        //pic is array of byte, image/png is media type, getname is name of scenario
        scenario.attach(pic,"image/png",scenario.getName());
        closeBrowser();
    }


}
