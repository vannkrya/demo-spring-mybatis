package com.example.demospringmybatis.controller;

import com.example.demospringmybatis.model.ApiResponse;
import com.example.demospringmybatis.model.Author;
import com.example.demospringmybatis.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController //create bean and handle http request, response json
//@RequestMapping("/books")
public class AuthorController {

    //inject
    //DI (final is need to initialize constructor)
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors{authorId}")
    public ResponseEntity<?> getAuthorById(@PathVariable int authorId) {
        Author author =  authorService.getAuthorById(authorId);
        ApiResponse<Author> response = new ApiResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK,
                "Successfully...",
                author
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authors")
    public ResponseEntity<?> insertAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(new ApiResponse<Author>(
                LocalDateTime.now(),
                HttpStatus.OK,
                "Successfully...",
                authorService.insertAuthor(author)
        ));
    }
}
