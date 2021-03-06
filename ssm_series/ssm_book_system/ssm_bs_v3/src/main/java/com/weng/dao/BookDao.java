package com.weng.dao;

import com.weng.bean.entity.Book;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface BookDao {
	Book queryById(long id);

	List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

	int addBook(Book book);

	int updateBook(Book book);

	int deleteBookById(long id);

	int countNum();

	List<Book> queryAllPlug();
}
