package practice.areaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.areaservice.service.ProvinceService;
import practice.common.Result;
import practice.entity.Province;

import java.util.List;

@RestController
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public Result getAllProvinces() {
        Result.ResultBuilder builder = Result.builder();
        List<Province> allProvinces;
        try {
            allProvinces = provinceService.getAllProvinces();
        } catch (Exception e) {
            return builder
                    .code(Result.ERROR)
                    .message("获取省份信息失败，请重试")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .data(allProvinces)
                .message("获取省份信息成功")
                .build();
    }

    @GetMapping("/{id}")
    public Result getProvinceById(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();
        Province province = provinceService.getProvinceById(id);
        if (province != null) {
            return builder
                    .code(Result.SUCCESS)
                    .data(province)
                    .message("获取省份信息成功")
                    .build();
        }
        return builder
                .code(Result.ERROR)
                .message("获取省份信息失败，请重试")
                .build();
    }

    @PostMapping
    public Result addProvince(@RequestBody Province province) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = provinceService.addProvince(province);
        if (res == null || res == 0) {
            return builder
                    .code(Result.ERROR)
                    .message("添加省份信息失败，请重试")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("添加省份信息成功")
                .build();
    }

    @PutMapping
    public Result updateProvince(@RequestBody Province province) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = provinceService.updateProvince(province);
        if (res == null || res == 0) {
            return builder
                    .code(Result.ERROR)
                    .message("修改省份信息失败，请重试")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("修改省份信息成功")
                .build();
    }

    @DeleteMapping("/{id}")
    public Result deleteProvinceByID(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = provinceService.deleteProvinceByID(id);
        if (res == null || res == 0) {
            return builder
                    .code(Result.ERROR)
                    .message("修删除省份信息失败，请重试")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("删除省份信息成功")
                .build();
    }
}
