package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WikipediaHomePage extends BasePage{
    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cdx-text-input__input")
    private WebElement searchInput;
    //cdx-button
    @FindBy(css = ".cdx-button--size-medium")
        private WebElement searchBtn;

    public WikipediaResultsPage searchValue(String name) {
        searchInput.sendKeys(name);
        searchBtn.click();
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        return new WikipediaResultsPage(driver);
    }

    //para seleccionar ingles como idioma

    /*@FindBy(css = "#searchLanguage")
    private WebElement languageButton;*/

    /*public void changeLanguageToEnglish(){
        Select selectLanguage = new Select(languageButton);
        selectLanguage.selectByValue("en");
    }*/
}
