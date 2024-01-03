package com.example.demospringmybatis.service;

import com.example.demospringmybatis.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(int authorId);

    Author insertAuthor(Author author);
}
