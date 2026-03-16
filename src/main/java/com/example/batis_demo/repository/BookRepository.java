package com.example.batis_demo.repository;

import com.example.batis_demo.model.entity.Book;
import com.example.batis_demo.model.request.BookRequest;
import com.example.batis_demo.model.response.ApiResponse;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface BookRepository {

    @Results(id = "BookMapper", value = {
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "publishDate", column = "published_date"),
            @Result(property = "author", column = "author_id",
                    one = @One(
                            select = "com.example.batis_demo.repository.AuthorRepository.getAuthorById"// or FetchType.EAGER
                    ))
    })

    @Select("""
        SELECT * FROM books OFFSET #{offSet} LIMIT #{size};
    """)
    List<Book> getAllBook(int offSet, int size);


    @ResultMap("BookMapper")
    @Select("""
        SELECT * FROM books WHERE book_id = #{bookId};
    """)
    Book getBookById(Long bookId);

    @ResultMap("BookMapper")
    @Select("""
        INSERT INTO books VALUES (default, #{req.title}, #{req.publishDate}, #{req.authorId}) RETURNING *;
    """)
    Book saveBook(@Param("req") BookRequest bookRequest);
}
