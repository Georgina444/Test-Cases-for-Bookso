package uni.pu.fmi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor

public class Book {

    private int bookId;
    private String title;
    private String bookDescription;
    private int pages;
    private String author;
    private Set<Genre> genres;
    private Set<Rating> ratings;
}
