package pages;

import core.BasePageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage extends BasePageDriver {

    @FindAll(@FindBy(xpath = "//div/a/h3"))
    private List<WebElement> resultList;
    public ResultPage () {
        PageFactory.initElements(driver, this);
    }

    public String getFirstTitle() {
        return resultList.get(0).getText();
    }

    public String getLastTitle() {
        return resultList.get(resultList.size()-1).getText();
    }
}
