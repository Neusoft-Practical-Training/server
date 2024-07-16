package practice.feignapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import practice.common.Result;

@FeignClient("user-service")
public interface GridMemberClient {
    @GetMapping("/grid-member/{id}")
    Result getGridMember(@PathVariable Integer id);
}
