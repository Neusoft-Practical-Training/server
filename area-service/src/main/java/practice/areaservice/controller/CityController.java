package practice.areaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.areaservice.service.CityService;
import practice.common.Result;
import practice.entity.City;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public Result getAllCities() {
        Result.ResultBuilder builder = Result.builder();

        List<City> all;
        try {
            all = cityService.getAll();
        } catch (Exception e) {
            return builder
                    .code(Result.ERROR)
                    .message("获取城市信息失败，请重试")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .data(all)
                .message("获取省份信息成功")
                .build();
    }

    @GetMapping("/{id}")
    public Result getCityById(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();
        City city = cityService.getCityById(id);
        if (city != null) {
            return builder
                    .code(Result.SUCCESS)
                    .data(city)
                    .message("获取城市信息成功")
                    .build();
        }
        return builder
                .code(Result.ERROR)
                .message("获取城市信息失败，请重试")
                .build();
    }

    @PostMapping
    public Result addCity(@RequestBody City city) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = cityService.addCity(city);
        if (res == null || res < 1) {
            return builder
                    .code(Result.ERROR)
                    .message("添加城市信息失败")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("添加城市信息成功")
                .build();
    }

    @PutMapping
    public Result updateCity(@RequestBody City city) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = cityService.updateCity(city);
        if (res == null || res < 1) {
            return builder
                    .code(Result.ERROR)
                    .message("修改城市信息失败")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("修改城市信息成功")
                .build();
    }

    @DeleteMapping("/{id}")
    public Result deleteCity(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = cityService.deleteCity(id);
        if (res == null || res < 1) {
            return builder
                    .code(Result.ERROR)
                    .message("删除城市信息失败")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("删除城市信息成功")
                .build();
    }
}
