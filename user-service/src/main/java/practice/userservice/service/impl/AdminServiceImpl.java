package practice.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.entity.Admin;
import practice.userservice.mapper.AdminMapper;
import practice.userservice.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getById(Integer id) {
        return adminMapper.selectById(id);
    }
}
