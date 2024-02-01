package pages.WebApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class YahooSearchPage extends CommonMethods {
    @FindBy(id="yschsp")
    public WebElement SearchInputField;

    public YahooSearchPage(){
        PageFactory.initElements(driver, this);
    }
}
