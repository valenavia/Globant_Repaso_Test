package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WikipediaHomePage;
import pages.WikipediaResultsPage;
import pojos.People;
import static io.restassured.RestAssured.*;

public class PeopleTestSteps {

    private final WebDriver driver = new ChromeDriver();
    private People people;
    WikipediaHomePage whp = new WikipediaHomePage(driver);
    WikipediaResultsPage wrp;

    @Given("I am a user at the Wikipedia Web Page")
    public void userInWikipedia(){
        driver.get("https://en.wikipedia.org/");
    }

    @When("I request the SW character with ID {int} from SWAPI")
    public void swapiRequest(int number){
        this.people = get("https://swapi.dev/api/people/" + number).then().assertThat().statusCode(200).extract().as(People.class);
    }

    @When("I search for the SW character's name on Wikipedia")
    public void searchCharacter() {
        wrp = whp.searchValue(people.getName());
    }

    @Then("I should see the character's Wikipedia page correctly displayed")
    public void characterPageIsDisplayed() {
        Assert.assertEquals(people.getName(), wrp.getPageTitle());
        Assert.assertTrue(wrp.sidebarIsPresent());
        Assert.assertTrue(wrp.navbarIsPresent());
    }

    @Then("all the main sections of the article should be displayed")
    public void allSectionsAreDisplayed() {
        wrp.allSectionsAreDisplayed();
    }

}
