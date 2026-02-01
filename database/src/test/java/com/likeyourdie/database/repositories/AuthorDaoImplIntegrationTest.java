package com.likeyourdie.database.repositories;

import com.likeyourdie.database.TestDataUtil;
import com.likeyourdie.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplIntegrationTest {
/*
    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRead(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        var result = underTest.findOne(author.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);

    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRead(){
        List<Author> authorList = TestDataUtil.createTestAuthorList();

        for (Author author : authorList){
            underTest.create(author);
        }

        var result = underTest.findMany();
        assertThat(result).hasSize(authorList.size());
        assertThat(result).isEqualTo(authorList);
    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        List<Author> authors = TestDataUtil.createTestAuthorList();
        Author author = authors.getFirst();
        underTest.create(author);

        Author newAuthor = authors.get(1);
        underTest.update(author.getId(), newAuthor);
        Optional<Author> result = underTest.findOne(newAuthor.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(newAuthor);
    }

    @Test
    public void testThatAuthorCanBeDeleted(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);

        underTest.delete(author.getId());

        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isEmpty();
    }

 */

}
