package com.example.demospringmybatis.repository;


import com.example.demospringmybatis.model.Author;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorRepository {

    @Select("""
            SELECT * FROM authors
            """)
    @Results(id = "authorMap", value = {
            @Result(property = "authorId", column = "author_id")
    })
    List<Author> getAllAuthors();

    @Select("""
            SELECT * FROM authors 
            WHERE author_id = #{authorId};
            """)
//    @Result(property = "authorId", column = "author_id")
    @ResultMap("authorMap")
    Author getAuthorById(int authorId);

    @Select("""
            INSERT INTO authors(name, gender)
            VALUES (#{author.name}, #{author.gender})
            RETURNING *
            """)
//    @Result(property = "authorId", column = "author_id")
    @ResultMap("authorMap")
    Author insertAuthor(@Param("author") Author author);
}
