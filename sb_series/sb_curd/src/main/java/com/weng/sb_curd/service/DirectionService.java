package com.weng.sb_curd.service;

import com.weng.sb_curd.entity.Blog;
import com.weng.sb_curd.entity.Direction;

import java.util.List;

public interface DirectionService {

    // 查
    Direction getDirectionById(Integer id);

    // 删
    void deleteDirectionById(Integer id);

    // 全
    List<Direction> getAllDirections();

    // 增
    void insertDirection(Direction direction);

    // 改
    void updateDirection(Direction direction);
}
