package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    private final WebDriver driver;

    private WebDriverWait webDriverWait10;
    private Actions actions;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }
        return webDriverWait10;
    }

    protected void verifyElementVisible(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement verifyElementClickable(WebElement element) {
        return getWait10().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clear(WebElement element) {
        element.clear();
    }

    protected void click(WebElement element) {
        verifyElementVisible(element);
        verifyElementClickable(element).click();
    }

    protected Actions getActions() {
        if (actions == null) {
            actions = new Actions(getDriver());
        }
        return actions;
    }

    protected String getTitle() {
        return getDriver().getTitle();
    }

    protected void scrollByVisibleElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void input(WebElement element, String text) {
        click(element);
        clear(element);
        element.sendKeys(text);
    }

    protected int getListSize(List<WebElement> list) {
        return list.size();
    }

    protected boolean areListElementsVisibleAndClickable(List<WebElement> elements) {
        int count = 0;
        List<WebElement> allElements = new ArrayList<>(elements);
        for (WebElement checkedElement : elements) {
            if (checkedElement.isDisplayed() && checkedElement.isEnabled()) {
                verifyElementClickable(checkedElement);
                count++;
            }
        }
        return elements.size() == count;
    }

}
