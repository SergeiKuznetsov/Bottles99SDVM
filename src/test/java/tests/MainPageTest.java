package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void checkTheTitleTest() {

        openBaseURL();
        getDriver().getTitle();
        getDriver().navigate().to("https://www.google.com/");
        getDriver().navigate().to("https://www.ups.com/track?loc=en_US&requester=ST/trackdetails");
    }
    @Test
    public void checkTheNewTest() {
        openBaseURL();
        getDriver().navigate().to("https://docs.github.com");
    }



}
