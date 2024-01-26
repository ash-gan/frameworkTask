package pages.WebApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class GoogleSearchPage extends CommonMethods {

    @FindBy(id="APjFqb")
    public WebElement SearchInputField;



    public GoogleSearchPage(){
        PageFactory.initElements(driver, this);
    }
}
