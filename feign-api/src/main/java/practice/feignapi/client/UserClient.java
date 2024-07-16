package practice.feignapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import practice.common.Result;
import practice.entity.User;

@FeignClient("user-service")
public interface UserClient {
    @GetMapping("/users/login")
    Result login(@RequestBody User user);
}