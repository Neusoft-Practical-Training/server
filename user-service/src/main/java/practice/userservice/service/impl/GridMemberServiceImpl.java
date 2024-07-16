package practice.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.entity.GridMember;
import practice.userservice.mapper.GridMemberMapper;
import practice.userservice.service.GridMemberService;

@Service
public class GridMemberServiceImpl implements GridMemberService {
    @Autowired
    private GridMemberMapper gridMemberMapper;

    @Override
    public GridMember getById(Integer id) {
        return gridMemberMapper.selectById(id);
    }
}
