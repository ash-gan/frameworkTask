package pages.WebApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class YahooResultsPage extends CommonMethods {

    @FindBy(xpath="(//h3/a/span)[1]")
    public WebElement firstResult;

    public YahooResultsPage(){
        PageFactory.initElements(driver, this);
    }
}
