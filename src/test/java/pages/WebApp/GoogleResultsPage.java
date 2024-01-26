package pages.WebApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class GoogleResultsPage extends CommonMethods {
    @FindBy(xpath="//span/a/h3")
    public List<WebElement> titleResult;

    @FindBy(xpath="(//a/h3)[1]")
    public WebElement firstResult;

    public GoogleResultsPage(){
        PageFactory.initElements(driver, this);
    }
}

