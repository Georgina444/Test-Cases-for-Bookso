package uni.pu.fmi.bookrating;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.services.RatingService;

import static org.junit.Assert.assertEquals;

public class RatingSteps
{

    private final StarModel starModel;
    private String bookTitle;

    private String comment;
    private String message;

    public RatingSteps(StarModel starModel)
    {
        this.starModel = starModel;

    }

    @Given("User opens details {string}")
    public void openSongDetails(String bookTitle)
    {
        this.bookTitle = bookTitle;
    }




    @When("user writes a comment {string}")
    public void addComment(String comment)
    {
        this.comment = comment;
    }


    @When("User submits rating")
    public void submitRating()
    {
        RatingService rateService = new RatingService();
        message = rateService.rateBook(bookTitle, starModel.getStars(), comment);
    }


    @Then("User gets a message {string}")
    public void checkMessage(String expectedMessage)
    {
        assertEquals(expectedMessage, message);
    }

}
