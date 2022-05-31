package com.weng.sb_curd.service.impl;

import com.weng.sb_curd.dao.DirectionDao;
import com.weng.sb_curd.entity.Blog;
import com.weng.sb_curd.entity.Direction;
import com.weng.sb_curd.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionDao directionDao;

    @Override
    public Direction getDirectionById(Integer id) {
        return directionDao.getOne(id);
    }

    @Override
    public void deleteDirectionById(Integer id) {
        directionDao.deleteById(id);
    }

    @Override
    public List<Direction> getAllDirections() {
        return directionDao.findAll();
    }

    @Override
    public void insertDirection(Direction direction) {
        directionDao.save(direction);
    }

    @Override
    public void updateDirection(Direction direction) {
        directionDao.save(direction);
    }
}
