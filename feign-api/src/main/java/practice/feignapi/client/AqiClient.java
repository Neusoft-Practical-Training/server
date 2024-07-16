package practice.feignapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import practice.common.Result;

@FeignClient("aqi-service")
public interface AqiClient {
    @GetMapping("/aqi")
    Result getAllAqi();

    @GetMapping("/aqi/{id}")
    Result getAqiById(@PathVariable Integer id);

}
