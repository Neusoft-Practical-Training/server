package practice.feignapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import practice.common.Result;
import practice.entity.Province;

@FeignClient("area-service")
public interface ProvinceClient {
    @GetMapping("/provinces")
    Result getAllProvinces();

    @GetMapping("/provinces/{id}")
    Result getProvinceById(@PathVariable Integer id);

    @PostMapping("/provinces")
    Result addProvince(@RequestBody Province province);

    @PutMapping("/provinces")
    Result updateProvince(@RequestBody Province province);

    @DeleteMapping("/provinces/{id}")
    Result deleteProvinceByID(@PathVariable Integer id);
}
