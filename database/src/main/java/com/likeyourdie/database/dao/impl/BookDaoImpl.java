package com.likeyourdie.database.dao.impl;

import com.likeyourdie.database.dao.BookDao;
import com.likeyourdie.database.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn, title, author_id) VALUES(?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthorid());
    }

    @Override
    public Optional<Book> findOne(String isbn) {
        List<Book> books = jdbcTemplate.query("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1", new BookRowMapper(), isbn);
        return books.stream().findFirst();
    }

    @Override
    public List<Book> findMany() {
        return jdbcTemplate.query("SELECT * from books",new BookRowMapper());
    }

    @Override
    public void update(String isbn, Book book) {
        jdbcTemplate.update("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                book.getIsbn(),
                book.getTitle(),
                book.getAuthorid(),
                isbn
        );

    }

    @Override
    public void delete(String isbn) {
        jdbcTemplate.update("DELETE FROM books where isbn = ?",
                isbn);
    }

    public static class BookRowMapper implements RowMapper<Book>{

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .title(rs.getString("title"))
                    .isbn(rs.getString("isbn"))
                    .authorid(rs.getLong("author_id"))
                    .build();
        }
    }
}
