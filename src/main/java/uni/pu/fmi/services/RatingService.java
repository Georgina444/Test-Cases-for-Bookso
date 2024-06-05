package uni.pu.fmi.services;

import uni.pu.fmi.db.MainRepo;
import uni.pu.fmi.models.Book;
import uni.pu.fmi.models.Rating;

public class RatingService
{
    public String rateBook(String bookTitle, Integer stars, String comment)
    {
        String errorMessage = validate(stars, comment);
        if (errorMessage != null)
        {
            return errorMessage;
        }
        Book book = getBook(bookTitle);
        MainRepo.getRatings().add(new Rating(1l, stars, comment, book));

        //You rated this book with 1 star
        return "You rated " + bookTitle + " with " + stars + " stars";
    }


    private static Book getBook(String bookTitle)
    {
        Book book = MainRepo.getBookList()
                .stream()
                .filter(s -> s.getTitle().equals(bookTitle))
                .findFirst()
                .orElse(null);
        return book;
    }


    private static String validate(Integer stars, String comment)
    {
        if (stars == null)
        {
            return "Choose a rate";
        }
        if (stars < 1 || stars > 10)
        {
            return "Rate from 1 to 5";
        }
        if (null != comment && comment.length() > 50)
        {
            return "Comment should be no longer than 100 symbols";
        }
        if (null != comment && !comment.isBlank() && !comment.matches("[\\w\\d\\.,!\\p{L}\\s-]+"))
        {
            return "You can't use forbidden characters!";
        }
        return null;
    }
}
