package uni.pu.fmi.services;

import uni.pu.fmi.db.MainRepo;
import uni.pu.fmi.models.Book;
import uni.pu.fmi.models.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookFilterService {

    public List<Book> load(String genreName, String bookTitle){

        List<Book> bookList = MainRepo.getBookList();
        List<Book> result = new ArrayList<>();
        result = filterByGenre(genreName, result, bookList);
        result = filterByBookTitle(bookTitle,result);
        return result;

    }

    private static List<Book> filterByBookTitle(String bookTitle, List<Book>result){
        if(bookTitle != null && !bookTitle.trim().isEmpty()){
            result = result.stream().filter(b ->b.getTitle().contains(bookTitle)).collect(Collectors.toList());
        }
        return result;
    }

    private static List<Book> filterByGenre(String genreName, List<Book>result,List<Book> bookList){
        if(genreName == null || genreName.trim().isEmpty()){
            result = bookList;
        } else{
            for(Book book : bookList){
                for(Genre genre : book.getGenres()){
                    if(genre.getGenreTitle().equals(genreName)){
                        result.add(book);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
