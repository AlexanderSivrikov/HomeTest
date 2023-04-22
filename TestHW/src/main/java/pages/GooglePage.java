package pages;

import core.BasePageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePageDriver {

    @FindBy(xpath = "//textarea[@type='search']")
    private WebElement inoutField;
    @FindBy(xpath = "//input[contains(@value, 'Google')]")
    private WebElement searchBtn;
    public GooglePage() {
        driver.get("https://google.co.il");
        PageFactory.initElements(driver, this);
    }
    public ResultPage searchTheText(String text){
        inoutField.sendKeys(text);
        searchBtn.click();
        return new ResultPage();
    }
}
