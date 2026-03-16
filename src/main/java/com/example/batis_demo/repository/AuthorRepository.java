package com.example.batis_demo.repository;

import com.example.batis_demo.model.entity.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
