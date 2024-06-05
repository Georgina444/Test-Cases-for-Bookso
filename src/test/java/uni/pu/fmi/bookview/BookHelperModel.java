package uni.pu.fmi.bookview;

import lombok.Getter;
import lombok.Setter;
import uni.pu.fmi.models.Book;

import java.util.List;

// Lombok automatically generates Getters and Setters for all fields in the class
@Getter
@Setter

public class BookHelperModel {

    private String genre;
    private String bookTitle;
    private List<Book> bookList;
}
