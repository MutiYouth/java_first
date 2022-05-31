package com.weng.sb_curd.service;

import com.weng.sb_curd.entity.Blog;
import com.weng.sb_curd.entity.Member;

import java.util.List;

public interface MemberService {

    // 查
    Member getMemberById(Integer id);

    // 删
    void deleteMemberById(Integer id);

    // 全
    List<Member> getAllMembers();

    // 增
    void insertMember(Member member);

    // 改
    void updateMember(Member member);
}
