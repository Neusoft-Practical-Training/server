package practice.userservice.service;

import practice.entity.User;

public interface UserService {
    User login(User user);

    Integer register(User user);

    Integer delete(Integer id);

    Integer update(User user);

    Boolean isLoginCodeExist(String loginCode);
}
