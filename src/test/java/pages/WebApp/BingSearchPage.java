package pages.WebApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class BingSearchPage extends CommonMethods {

    @FindBy(id="sb_form_q")
    public WebElement bingSearchInput;

    @FindBy(css="span.sa_tm_text")
    public List<WebElement> bingSearchResults;



    public BingSearchPage(){
        PageFactory.initElements(driver, this);
    }
}
