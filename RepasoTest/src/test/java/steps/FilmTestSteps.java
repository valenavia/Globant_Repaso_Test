package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.WikipediaEditPage;
import pages.WikipediaHomePage;
import pages.WikipediaResultsPage;
import pojos.Films;
import pojos.People;

import java.util.Random;

import static io.restassured.RestAssured.get;

public class FilmTestSteps {

    private final WebDriver driver = new ChromeDriver();
    private Films film;
    WikipediaHomePage whp = new WikipediaHomePage(driver);
    WikipediaResultsPage wrp;
    WikipediaEditPage wep;

    @Given("I am at the Wikipedia Web Page")
    public void i_am_at_the_wikipedia_web_page() {
        driver.get("https://en.wikipedia.org/");
    }

    @When("I request the SW film with ID number from SWAPI from a random number")
    public void i_request_the_sw_film_with_id_number_from_swapi_from_a_random_number_between() {
        //int random = new Random().nextInt(6)+1;
        this.film = get("https://swapi.dev/api/films/" + 2).then().extract().as(Films.class);
    }

    @When("I search for the SW films name on Wikipedia")
    public void i_search_for_the_sw_films_name_on_wikipedia() {
        wrp = whp.searchValue(film.getTitle());
    }
    @Then("I should see the edit element correctly displayed and I click on it")
    public void i_should_see_the_edit_element_correctly_displayed() {
        Assert.assertTrue(wrp.titleIsDisplayed());
        wep = wrp.clickOnEditBtn();
        wep.continuarBtn();
    }
    @Then("the title of the Wikipedia edit page should match the film's name")
    public void the_title_of_the_wikipedia_edit_page_should_match_the_film_s_name() {
        Assert.assertTrue(wep.titleIsDisplayed());
        Assert.assertEquals(film.getTitle(), wep.getPageTitle());
    }
}
