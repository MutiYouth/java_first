package com.weng.sb_curd.service;

import com.weng.sb_curd.entity.Blog;

import java.util.List;

public interface BlogService {

    // 查
    Blog getBlogById(Integer id);

    // 删
    void deleteBlogById(Integer id);

    // 全
    List<Blog> getAllBlogs();

    // 增
    void insertBlog(Blog blog);

    // 改
    void updateBlog(Blog blog);

}
