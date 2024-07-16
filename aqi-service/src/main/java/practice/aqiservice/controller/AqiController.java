package practice.aqiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.aqiservice.service.AqiService;
import practice.common.Result;
import practice.entity.Aqi;

import java.util.List;

@RestController
@RequestMapping("/aqi")
public class AqiController {
    @Autowired
    private AqiService aqiService;

    /**
     * get all aqi data
     *
     * @return
     */
    @GetMapping
    public Result getAqiList() {
        List<Aqi> aqiList = aqiService.getAqiList();
        Result.ResultBuilder builder = Result.builder();
        return builder
                .code(Result.SUCCESS)
                .data(aqiList)
                .build();
    }

    /**
     * get aqi by id
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getAqiById(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();

        Aqi aqiById = aqiService.getAqiById(id);
        if (aqiById != null) {
            return builder
                    .code(Result.SUCCESS)
                    .data(aqiById)
                    .build();
        }
        // not exist
        return builder
                .code(Result.ERROR)
                .message("查询aqi失败，请重试")
                .build();
    }

    /**
     * add aqi
     *
     * @param aqi
     * @return
     */
    @PostMapping
    public Result addAqi(@RequestBody Aqi aqi) {
        Result.ResultBuilder builder = Result.builder();

        Integer res = aqiService.addAqi(aqi);
        if (null == res || 0 == res) {
            return builder
                    .code(Result.ERROR)
                    .message("添加aqi数据失败，请重试")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("添加aqi数据成功")
                .build();
    }

    /**
     * update aqi
     *
     * @param aqi
     * @return
     */
    @PutMapping
    public Result updateAqi(@RequestBody Aqi aqi) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = aqiService.updateAqi(aqi);
        if (null == res || 0 == res) {
            return builder
                    .code(Result.ERROR)
                    .message("修改aqi数据失败")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("修改aqi数据成功")
                .build();
    }

    /**
     * delete aqi by id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteAqi(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = aqiService.deleteAqi(id);
        if (null == res || 0 == res) {
            return builder
                    .code(Result.ERROR)
                    .message("删除aqi数据失败，请重试")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("删除aqi数据成功")
                .build();
    }
}
