package com.weng.sb_curd.service;

import com.weng.sb_curd.entity.Blog;
import com.weng.sb_curd.entity.Production;

import java.util.List;

public interface ProductionService {

    // 查
    Production getProductionById(Integer id);

    // 删
    void deleteProductionById(Integer id);

    // 全
    List<Production> getAllProductions();

    // 增
    void insertProduction(Production production);

    // 改
    void updateProduction(Production production);
}
