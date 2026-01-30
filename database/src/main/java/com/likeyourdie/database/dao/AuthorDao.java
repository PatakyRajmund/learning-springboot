package com.likeyourdie.database.dao;

import com.likeyourdie.database.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {

    void create(Author author);

    Optional<Author> findOne(long id);

    List<Author> findMany();

    void update(long id, Author author);

    void delete(long id);
}
