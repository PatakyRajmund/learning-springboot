package com.likeyourdie.database.dao.impl;

import com.likeyourdie.database.domain.Author;
import com.likeyourdie.database.domain.Book;

import java.util.ArrayList;
import java.util.List;

public final class TestDataUtil {
    private TestDataUtil(){

    }


    static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .age(80)
                .name("Name1")
                .build();
    }

    static Book getTestBook() {
        return Book.builder()
                .isbn("Mock ISBN")
                .title("Book title")
                .authorid(1L)
                .build();
    }

    static List<Author> createTestAuthorList(){
        List<Author> authors = new ArrayList<>();
        Author tmpAuthor = null;
        for(int i = 0; i<3; i++){
            tmpAuthor = Author.builder()
                    .id((long) i)
                    .name("Author "+ i)
                    .age(40 + i)
                    .build();
            authors.add(tmpAuthor);
        }
        return authors;
    }

    static List<Book> createTestBookListBelongingToAuthor(Author author){
        List<Book> books = new ArrayList<>();
        Book tmpBook = null;
        for(int i = 0; i<3 ; i++){
            tmpBook = Book.builder()
                    .isbn("ISBN "+ i)
                    .title("TITLE " + i)
                    .authorid(author.getId())
                    .build();
            books.add(tmpBook);
        }
        return books;
    }
}
