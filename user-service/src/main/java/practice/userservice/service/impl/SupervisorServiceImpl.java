package practice.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.entity.Supervisor;
import practice.userservice.mapper.SupervisorMapper;
import practice.userservice.service.SupervisorService;

@Service
public class SupervisorServiceImpl implements SupervisorService {
    @Autowired
    private SupervisorMapper supervisorMapper;

    @Override
    public Supervisor getById(Integer id) {
        return supervisorMapper.selectById(id);
    }
}
