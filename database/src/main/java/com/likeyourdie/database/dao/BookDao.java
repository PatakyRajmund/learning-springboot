package com.likeyourdie.database.dao;


import com.likeyourdie.database.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> findMany();

    void update(String isbn, Book book);

    void delete(String isbn);
}
