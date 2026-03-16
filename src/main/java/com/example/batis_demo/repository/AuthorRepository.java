package com.example.batis_demo.repository;

import com.example.batis_demo.model.entity.Author;
import org.apache.ibatis.annotations.*;

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
}
