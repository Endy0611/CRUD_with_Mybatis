package com.example.batis_demo.repository;

import com.example.batis_demo.model.entity.Author;
import com.example.batis_demo.model.request.AuthorRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Mapper
public interface AuthorRepository {
    @Results(id="authorMapper", value ={
            @Result(property = "authorId", column = "author_id")
    })
    @Select("""
        SELECT * FROM authors OFFSET #{offSet} LIMIT #{size};
    """)
    List<Author> getAllAuthor(int offSet, int size);

    @ResultMap("authorMapper")
    @Select("""
        SELECT * FROM authors WHERE author_id = #{authorId}
    """)
    Author getAuthorById(Long authorId);


    @ResultMap("authorMapper")
    @Select("""
        INSERT INTO authors VALUES (default, #{req.name}, #{req.gender}) RETURNING *;
    """)
    Author saveAuthor(@Param ("req") AuthorRequest authorRequest);


    @ResultMap("authorMapper")
    @Select("""
    DELETE FROM authors WHERE author_id = #{authorId} RETURNING *;
    """)
    Author deleteAuthorById(Long authorId);
}
