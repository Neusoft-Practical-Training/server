package practice.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.userservice.mapper.GridMemberMapper;
import practice.userservice.service.GridMemberService;

@Service
public class GridMemberServiceImpl implements GridMemberService {
    @Autowired
    private GridMemberMapper gridMemberMapper;
}
