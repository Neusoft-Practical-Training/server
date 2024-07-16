package practice.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.entity.User;
import practice.userservice.mapper.UserMapper;
import practice.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("login_code", user.getLoginCode())
                .eq("password", user.getPassword());
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public Integer register(User user) {
        System.out.println("user = " + user);
        return userMapper.insert(user);
    }

    @Override
    public Integer delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer update(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Boolean isLoginCodeExist(String loginCode) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("login_code", loginCode);
        User user = userMapper.selectOne(queryWrapper);
        return user != null;
    }
}
