package uni.pu.fmi.db;

import lombok.Getter;
import uni.pu.fmi.models.Book;
import uni.pu.fmi.models.Genre;
import uni.pu.fmi.models.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class MainRepo {

    // static is for predefined data
    private static List<Book> bookList = new ArrayList<>();
    private static List<Genre> genres = new ArrayList<>();
    private static List<Rating> ratings = new ArrayList<>();

    static{
        Genre romance = new Genre(1,"Romance","Romantic love stories");
        Genre trailer = new Genre(2,"Trailer","Teasers crafting emotional responses to a story.");
        Genre comedy = new Genre(3,"Comedy","Humorous stories for entertainment");
        Genre selfImprovement = new Genre(4,"Self-Improvement","Motivating and growth oriented books");


        bookList.add(new Book(1,"The Monk who sold his Ferrari","A businessman who found fulfillment in simple things",247,"Robin Sharma", Set.of(selfImprovement),Set.of()));
        bookList.add(new Book(2,"Rich Dad, Poor Dad","A guide to financial freedom and a new perspective to life",321,"Robert Kiosaki", Set.of(selfImprovement),Set.of()));
        bookList.add(new Book(3,"Good Omens","I have laughed so hard.. Highly recommended!",182,"Neil Gaiman", Set.of(comedy),Set.of()));
        bookList.add(new Book(4,"Only Friends","Platonic love story that will melt your heart",466,"Coline Hover", Set.of(romance),Set.of()));

        genres.add(romance);
        genres.add(trailer);
        genres.add(comedy);
        genres.add(selfImprovement);

    }

    public static List<Genre> getGenres(){return genres;}
    public static List<Book> getBookList(){return bookList;};
    public static List<Rating> getRatings(){return ratings;};

}
