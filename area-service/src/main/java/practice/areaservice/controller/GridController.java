package practice.areaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.areaservice.service.GridService;
import practice.common.Result;
import practice.entity.Grid;

import java.util.List;

@RestController
@RequestMapping("/grids")
public class GridController {
    @Autowired
    private GridService gridService;

    @GetMapping
    public Result getGrids() {
        Result.ResultBuilder builder = Result.builder();
        List<Grid> grids;
        try {
            grids = gridService.getGrids();
        } catch (Exception e) {
            return builder
                    .code(Result.ERROR)
                    .message("获取网格信息失败，请重试")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .data(grids)
                .message("获取网格信息成功")
                .build();
    }

    @GetMapping("/{id}")
    public Result getGridById(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();

        Grid grid = gridService.getGrid(id);
        if (grid != null) {
            return builder
                    .code(Result.SUCCESS)
                    .data(grid)
                    .message("获取网格信息成功")
                    .build();

        }
        return builder
                .code(Result.ERROR)
                .message("获取网格信息失败，请重试")
                .build();
    }

    @PostMapping
    public Result addGrid(@RequestBody Grid grid) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = gridService.addGrid(grid);
        if (res == null || res < 1) {
            return builder
                    .code(Result.ERROR)
                    .message("添加网格信息失败")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("添加网格信息成功")
                .build();
    }

    @PutMapping
    public Result updateGrid(@RequestBody Grid grid) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = gridService.updateGrid(grid);
        if (res == null || res < 1) {
            return builder
                    .code(Result.ERROR)
                    .message("修改网格信息失败")
                    .build();
        }
        return builder
                .code(Result.SUCCESS)
                .message("修改网格信息成功")
                .build();
    }

    @DeleteMapping("/{id}")
    public Result deleteGrid(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();
        Integer res = gridService.deleteGrid(id);
        if (res == null || res < 1) {
            return builder.code(Result.ERROR)
                    .message("删除网格信息失败")
                    .build();
        }
        return builder.code(Result.SUCCESS)
                .message("删除网格信息成功")
                .build();
    }
}
