package com.example.demospringmybatis.service;

import com.example.demospringmybatis.model.Author;
import com.example.demospringmybatis.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component, @Repository
@Service //bean
public class AuthorServiceImp implements AuthorService{

    //inject
    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    @Override
    public Author getAuthorById(int authorId) {
        return authorRepository.getAuthorById(authorId);
    }

    @Override
    public Author insertAuthor(Author author) {
        return authorRepository.insertAuthor(author);
    }
}
