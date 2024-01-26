package pages.WebApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class BingResultsPage extends CommonMethods {

    @FindBy(xpath="//h2/a")
    public List<WebElement> links;

    @FindBy(xpath="(//h2/a)[1]")
    public WebElement firstResult;

    public BingResultsPage(){
        PageFactory.initElements(driver, this);
    }
}
