package practice.feignapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import practice.common.Result;
import practice.entity.Aqi;

@FeignClient("aqi-service")
public interface AqiClient {
    @GetMapping("/aqi")
    Result getAqiList();

    @GetMapping("/aqi/{id}")
    Result getAqiById(@PathVariable Integer id);

    @PostMapping("/aqi")
    Result addAqi(@RequestBody Aqi aqi);

    @PutMapping("/aqi")
    Result updateAqi(@RequestBody Aqi aqi);

    @DeleteMapping("/aqi/{id}")
    Result deleteAqi(@PathVariable Integer id);
}
