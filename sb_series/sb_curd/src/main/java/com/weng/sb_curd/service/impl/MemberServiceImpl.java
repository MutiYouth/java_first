package com.weng.sb_curd.service.impl;

import com.weng.sb_curd.dao.MemberDao;
import com.weng.sb_curd.entity.Member;
import com.weng.sb_curd.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member getMemberById(Integer id) {
        return memberDao.getOne(id);
    }

    @Override
    public void deleteMemberById(Integer id) {
        memberDao.deleteById(id);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberDao.findAll();
    }

    @Override
    public void insertMember(Member member) {
        memberDao.save(member);
    }

    @Override
    public void updateMember(Member member) {
        memberDao.save(member);
    }
}
