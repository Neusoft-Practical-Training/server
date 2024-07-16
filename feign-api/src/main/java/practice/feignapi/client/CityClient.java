package practice.feignapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import practice.common.Result;
import practice.entity.City;

@FeignClient("area-service")
public interface CityClient {
    @GetMapping("/cities")
    Result getAllCities();

    @GetMapping("/cities/{id}")
    Result getCityById(@PathVariable Integer id);

    @PostMapping("/cities")
    Result addCity(@RequestBody City city);

    @PutMapping("/cities")
    Result updateCity(@RequestBody City city);

    @DeleteMapping("/cities/{id}")
    Result deleteCity(@PathVariable Integer id);

}
