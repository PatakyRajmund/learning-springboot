package com.likeyourdie.database.dao.impl;

import com.likeyourdie.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreatesBookAndGeneratesCorrectSQL() {
        Book book = TestDataUtil.getTestBook();

        underTest.create(book);
        verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, author_id) VALUES(?, ?, ?)"),
            eq(book.getIsbn()), eq(book.getTitle()), eq(book.getAuthorid())
        );
    }

    @Test
    public void testThatFindsOneBookAndGeneratesCorrectSQL(){
        underTest.findOne("Mock ISBN");

        verify(jdbcTemplate).query(eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"), ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(), eq("Mock ISBN"));

    }

    @Test
    public void testThatFindsAllBooksAndGeneratesCorrectSQL(){
        underTest.findMany();

        verify(jdbcTemplate).query(eq("SELECT * from books"),ArgumentMatchers.<BookDaoImpl.BookRowMapper>any());

    }

    @Test
    public void testThatUpdateGeneratesCorrectSQL(){
        Book book = TestDataUtil.getTestBook();
        underTest.update(book.getIsbn(), book);

        verify(jdbcTemplate).update(eq("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?"),
                eq(book.getIsbn()),
                eq(book.getTitle()),
                eq(book.getAuthorid()),
                eq(book.getIsbn())
        );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSQL(){
        Book book = TestDataUtil.getTestBook();
        underTest.delete(book.getIsbn());

        verify(jdbcTemplate).update(eq("DELETE FROM books where isbn = ?"),
                eq(book.getIsbn()));
    }

}
