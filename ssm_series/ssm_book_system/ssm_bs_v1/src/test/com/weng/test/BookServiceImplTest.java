package com.weng.test;

import com.weng.entity.Book;
import com.weng.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class BookServiceImplTest extends BookDaoTest {
  @Autowired
  private BookService bookService;

  @Test
  public void getById() {
    //在service里面改了一下名字，其实就是dao里面的queryById
    Book book = bookService.getById(101);
    System.out.println(book);
  }
  @Test
  public void countNum(){
    int i = bookService.countNum();
    System.out.println(i);
  }
}
