package com.weng.sb_curd.service.impl;

import com.weng.sb_curd.dao.ProductionDao;
import com.weng.sb_curd.entity.Production;
import com.weng.sb_curd.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionDao productionDao;

    @Override
    public Production getProductionById(Integer id) {
        return productionDao.getOne(id);
    }

    @Override
    public void deleteProductionById(Integer id) {
        productionDao.deleteById(id);
    }

    @Override
    public List<Production> getAllProductions() {
        return productionDao.findAll();
    }

    @Override
    public void insertProduction(Production production) {
        productionDao.save(production);
    }

    @Override
    public void updateProduction(Production production) {
        productionDao.save(production);
    }
}
