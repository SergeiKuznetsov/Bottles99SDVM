package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void checkTheTitle() {

        openBaseURL();
        getDriver().getTitle();
    }
}
