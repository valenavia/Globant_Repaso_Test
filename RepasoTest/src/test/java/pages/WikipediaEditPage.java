package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

import org.openqa.selenium.support.ui.Wait;

import java.awt.event.KeyEvent;
import java.security.Key;

public class WikipediaEditPage extends BasePage{

    public WikipediaEditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstHeadingTitle")
    private WebElement pageTitle;

    @FindBy(className = "oo-ui-widget")
    private WebElement continuarBtn;

    public boolean titleIsDisplayed(){
        return pageTitle.isDisplayed();
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void continuarBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continuarBtn));
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
