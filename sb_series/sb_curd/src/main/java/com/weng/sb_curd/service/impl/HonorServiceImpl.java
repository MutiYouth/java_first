package com.weng.sb_curd.service.impl;

import com.weng.sb_curd.dao.HonorDao;
import com.weng.sb_curd.entity.Honor;
import com.weng.sb_curd.service.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HonorServiceImpl implements HonorService {

    @Autowired
    private HonorDao honorDao;

    @Override
    public Honor getHonorById(Integer id) {
        return honorDao.getOne(id);
    }

    @Override
    public void deleteHonorById(Integer id) {
        honorDao.deleteById(id);
    }

    @Override
    public List<Honor> getAllHonors() {
        return honorDao.findAll();
    }

    @Override
    public void insertHonor(Honor honor) {
        honorDao.save(honor);
    }

    @Override
    public void updateHonor(Honor honor) {
        honorDao.save(honor);
    }
}
