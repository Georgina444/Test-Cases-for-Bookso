package uni.pu.fmi.bookview;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.models.Genre;
import uni.pu.fmi.services.BookFilterService;
import uni.pu.fmi.services.GenreService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookViewSteps {
    private final BookHelperModel helperModel;

    public BookViewSteps(BookHelperModel helperModel) {
        this.helperModel = helperModel;
    }

    @When("отваряне на приложението")
    public void openApp() {
        //missing real app
    }

    @When("натиска бутона за търсене")
    public void clickSearchButton() {
        BookFilterService bookFilterService = new BookFilterService();
        helperModel.setBookList(bookFilterService.load(helperModel.getGenre(),
                helperModel.getBookTitle()));
    }


    @Then("Визуализира се списък с жанрове")
    public void checkGenre() {
        GenreService categoryService = new GenreService();
        List<Genre> genres = categoryService.load();
        assertTrue(genres.stream().anyMatch(c -> c.getGenreTitle().equals("Romance")));
        assertTrue(genres.stream().anyMatch(c -> c.getGenreTitle().equals("Self-Improvement")));
        assertTrue(genres.stream().anyMatch(c -> c.getGenreTitle().equals("Trailer")));
        assertEquals(3, genres.size());
    }

    @When("потребителя избере жанър: {string}")
    public void chooseCategory(String genre) {
        this.helperModel.setGenre(genre);
    }


    @When("потребителя въвежда заглавие на книгата {string} в полето за търсене")
    public void addBookInSearchField(String bookTitle) {
        this.helperModel.setBookTitle(bookTitle);
    }
}
