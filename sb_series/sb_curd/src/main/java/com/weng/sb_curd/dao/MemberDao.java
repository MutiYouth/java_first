package com.weng.sb_curd.dao;

import com.weng.sb_curd.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member,Integer> {
}
