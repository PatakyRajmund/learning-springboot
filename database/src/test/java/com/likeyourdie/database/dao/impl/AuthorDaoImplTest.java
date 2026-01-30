package com.likeyourdie.database.dao.impl;

import com.likeyourdie.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreatsAuthorGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES(?, ?, ?)"),
                eq(1L), eq(author.getName()), eq(author.getAge())
        );

    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSQL(){
        underTest.findOne(1L);

        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"), ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(), eq(1L));
    }

    @Test
    public void testThatFindManyGeneratesTheCorrectSQL(){
        underTest.findMany();
        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any());
    }

    @Test
    public void testThatUpdateGeneratesTheCorrectSQL(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.update(3L, author);

        verify(jdbcTemplate).update(eq("UPDATE authors SET id = ?, name = ? , age = ? WHERE id = ?"),
                eq(author.getId()),
                eq(author.getName()),
                eq(author.getAge()),
                eq(3L)
                );
    }

    @Test
    public void testThatDeleteGeneratesTheCorrectSQL(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.delete(author.getId());

        verify(jdbcTemplate).update(eq("DELETE FROM authors WHERE id = ?"),
                eq(author.getId()));
    }
}
