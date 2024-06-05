package uni.pu.fmi.bookview;
import io.cucumber.java.en.Then;
import uni.pu.fmi.models.Book;
import uni.pu.fmi.services.BookFilterService;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CheckBookList {

    private final BookHelperModel helperModel;

    public CheckBookList(BookHelperModel helperModel){this.helperModel = helperModel;}

    @Then("Visualises Book List with current {int} books")
    public void checkBookList(int expectedBookCount) {
        if (null == helperModel.getBookList()) {
            BookFilterService bookFilterService = new BookFilterService();
            helperModel.setBookList(bookFilterService.load(helperModel.getGenre(), helperModel.getBookTitle()));
        }
        assertNotNull(helperModel.getBookList());
        assertEquals(expectedBookCount, helperModel.getBookList().size());
    }
}
