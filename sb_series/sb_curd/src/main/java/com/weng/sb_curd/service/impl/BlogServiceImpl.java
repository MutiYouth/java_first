package com.weng.sb_curd.service.impl;

import com.weng.sb_curd.dao.BlogDao;
import com.weng.sb_curd.entity.Blog;
import com.weng.sb_curd.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlogById(Integer id) {
        return blogDao.getOne(id);
    }

    @Override
    public void deleteBlogById(Integer id) {
        blogDao.deleteById(id);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogDao.findAll();
    }

    @Override
    public void insertBlog(Blog blog) {
        blogDao.save(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogDao.save(blog);
    }
}
