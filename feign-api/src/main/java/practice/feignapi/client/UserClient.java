package practice.feignapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import practice.common.Result;
import practice.entity.AqiAssignment;
import practice.entity.User;

@FeignClient("user-service")
public interface UserClient {
    @GetMapping("/users/login")
    Result login(@RequestBody User user);

    @PostMapping("/users")
    Result register(@RequestBody User user);

    @DeleteMapping("/users/{id}")
    Result delete(@PathVariable Integer id);

    @PutMapping("/users")
    Result update(@RequestBody User user);
}