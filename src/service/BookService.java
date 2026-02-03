package service;

import exceptions.NoBooksFoundException;
import model.Book;
import java.util.*;

public class BookService {

    private final List<Book> books;

    public BookService(List<Book> books) { this.books = books; }

    public void registerBook(Book book) { this.books.add(book); }
    public List<Book> listAll() {
        if(books.isEmpty()) throw new NoBooksFoundException("NO BOOKS FOUND.");
        return List.copyOf(this.books);
    }
    public List<Book> listAvailable() {
        List<Book> filter = this.books.stream().filter(Book::isAvailable).toList();
        if(filter.isEmpty()) throw new NoBooksFoundException("NO AVAILABLE BOOKS FOUND.");
        return filter;
    }
    public Book searchById(String id){
        Book filter = this.books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
        if(filter == null) throw new NoBooksFoundException("NO BOOKS FOUND.");
        return filter;
    }
    public List<Book> searchByTitle(String title){
        List<Book> filter = this.books.stream().filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
        if(filter.isEmpty()) throw new NoBooksFoundException(("NO BOOKS FOUND."));
        return filter;
    }
    public List<Book> searchByAuthor(String author){
        List<Book> filter = this.books.stream().filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase())).toList();
        if(filter.isEmpty()) throw new NoBooksFoundException(("NO BOOKS FOUND."));
        return filter;
    }
    public List<Book> searchByPublisher(String publisher){
        List<Book> filter = this.books.stream().filter(book -> book.getPublisher().toLowerCase().contains(publisher.toLowerCase())).toList();
        if(filter.isEmpty()) throw new NoBooksFoundException(("NO BOOKS FOUND."));
        return filter;
    }
    public List<Book> searchByYear(int year){
        List<Book> filter = this.books.stream().filter(book -> book.getYearPublication() == year).toList();
        if(filter.isEmpty()) throw new NoBooksFoundException(("NO BOOKS FOUND."));
        return filter;
    }

}
