package practice.userservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import practice.common.Result;
import practice.entity.User;
import practice.feignapi.client.UserClient;
import practice.userservice.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    private final UserClient userClient;

    /**
     * login by login code and password
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        // check with md5
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user = userService.login(user);

        Result.ResultBuilder builder = Result.builder();

        // login success
        if (user != null) {
            user.setPassword(null);
//            String token = JwtTool.generateToken(user.getLoginCode());

            String token = "token";
            return builder.code(Result.SUCCESS).data(token).message("登录成功").build();
        }
        // login failure
        return builder.code(Result.ERROR).message("用户名或密码错误，请重试").build();
    }

    /**
     * register
     *
     * @param user
     * @return
     */
    @PostMapping
    public Result register(@RequestBody User user) {
        Result.ResultBuilder builder = Result.builder();

        // login code exists
        Boolean exist = userService.isLoginCodeExist(user.getLoginCode());
        if (exist) {
            return builder.code(Result.ERROR).message("该用户名已存在，请重试").build();
        }

        // store encrypted value in db
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        Integer res = userService.register(user);
        // didn't insert data
        if (null == res || 0 == res) {
            return builder.code(Result.ERROR).message("用户注册失败，请重试").build();
        }
        // insert one record
        return Result.builder().code(Result.SUCCESS).message("用户注册成功").build();
    }

    /**
     * delete by id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();

        Integer res = userService.delete(id);
        // didn't delete data
        if (null == res || 0 == res) {
            return builder.code(Result.ERROR).message("删除用户失败，请重试").build();
        }
        // delete one record
        return Result.builder().code(Result.SUCCESS).message("删除用户成功").build();
    }

    /**
     * update user info
     *
     * @param user
     * @return
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        Result.ResultBuilder builder = Result.builder();

        // login code exists
        Boolean exist = userService.isLoginCodeExist(user.getLoginCode());
        if (exist) {
            return builder.code(Result.ERROR).message("该用户名已存在，请重试").build();
        }

        // update password
        if (user.getPassword() != null) {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        }

        Integer res = userService.update(user);
        // didn't update data
        if (null == res || 0 == res) {
            return builder.code(Result.ERROR).message("修改用户信息失败，请重试").build();
        }
        // update one record
        return Result.builder().code(Result.SUCCESS).message("修改用户信息成功").build();
    }

    // TODO: This is a demo for testing openFeign client
    @PostMapping("/test")
    public Result test(@RequestBody User user) {
        return userClient.login(user);
    }
}
