package com.ust.service;

import com.ust.domain.Book;
import com.ust.exceptions.BookNotFoundException;
import com.ust.exceptions.DuplicateBookException;
import com.ust.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        log.debug("getAllBooks");
        return bookRepository.findAll();
    }
/*
    public Book getBookById(int id) {
        log.debug("getBookById : {}",id);
        return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found"));
    }

 */
    public Book getBookById(Long id) {
        log.debug("getBookById : {}",id);
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
    }


    /*public Book addBook(Book book) {
        log.debug("addBook : {}",book);
        bookRepository.findById(book.getId())
                .ifPresent(existingBook -> {
                    log.error("Book already exists with id : {}",existingBook.getId());
                    throw new DuplicateBookException("Book already exists with id :{}"+existingBook.getId());
                });
        //log.debug("Book doesnt exist with id: {}",Book.getId());
        return bookRepository.save(book);
      }
     */

    public Book addBook(Book book) {
        log.debug("addBook : {}", book);
        return bookRepository.save(book);
    }


    @Override
    public Book updateBook(Long id, Book book) {
        log.debug("updateBook : {}",book);
        var existingBook = getBookById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setStock(book.getStock());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        log.debug("deleteBook : {}",id);
        var existingBook = bookRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException("Book not found"));
        bookRepository.delete(existingBook);
    }

    @Override
    public void updateStock(Long id, int newStock) {
        log.debug("updateStock : {}",id);
        var book = getBookById(id);
        book.setStock(newStock);
        bookRepository.save(book);
    }
}
