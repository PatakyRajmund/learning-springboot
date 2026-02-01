package com.likeyourdie.database.repositories;

import com.likeyourdie.database.TestDataUtil;
import com.likeyourdie.database.domain.Author;
import com.likeyourdie.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegratonTest {
   /* private BookDaoImpl underTest;
    private AuthorDao authorDao;
    @Autowired
    public BookDaoImplIntegratonTest(BookDaoImpl underTest, AuthorDao authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void testThatCreatesAndReadsABook(){
        Book book = TestDataUtil.getTestBook();
        Author author = TestDataUtil.createTestAuthor();
        book.setAuthorid(author.getId());

        authorDao.create(author);
        underTest.create(book);

        var result = underTest.findOne(book.getIsbn());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);
        List<Book> bookList = TestDataUtil.createTestBookListBelongingToAuthor(author);

        for(Book book : bookList){
            underTest.create(book);
        }

        List<Book> result = underTest.findMany();

        assertThat(result).hasSize(bookList.size()).isEqualTo(bookList);

    }

    @Test
    public void testThatBookCanBeUpdated()
    {
        Author author = TestDataUtil.createTestAuthor();
        List<Book> booksList = TestDataUtil.createTestBookListBelongingToAuthor(author);

        Book book = booksList.getFirst();
        Book newBook = booksList.get(1);

        authorDao.create(author);
        underTest.create(book);

        underTest.update(book.getIsbn(),newBook);
        Optional<Book> result  = underTest.findOne(newBook.getIsbn());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(newBook);
    }

    @Test
    public void testThatBookCanBeDeleted(){
        Book book = TestDataUtil.getTestBook();
        Author author = TestDataUtil.createTestAuthor();
        book.setAuthorid(author.getId());

        authorDao.create(author);
        underTest.create(book);

        underTest.delete(book.getIsbn());
        Optional<Book> result = underTest.findOne(book.getIsbn());

        assertThat(result).isEmpty();

    }

    */
}
