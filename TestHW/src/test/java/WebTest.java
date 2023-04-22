import core.BaseTestDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.ResultPage;

public class WebTest extends BaseTestDriver {
    @Test
    public void firstTest() {
        String expectedText = "Java";
        String unexpectedText = "Interview";
        ResultPage googlePage = new GooglePage().searchTheText(expectedText);
        Assert.assertTrue(googlePage.getFirstTitle().contains(expectedText));
        Assert.assertFalse(googlePage.getLastTitle().contains(unexpectedText));
    }
}
