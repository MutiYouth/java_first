package com.weng.sb_curd.dao;

import com.weng.sb_curd.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<Blog,Integer> {
}
