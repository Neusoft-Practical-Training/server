package practice.feignapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import practice.common.Result;
import practice.entity.AqiAssignment;

@FeignClient("user-service")
public interface AdminClient {
    @PostMapping("/admins/assign")
    Result assignAdmin(@RequestBody AqiAssignment aqiAssignment);

    @PostMapping("/admins/{id}}")
    Result getAdmin(@PathVariable Integer id);
}
