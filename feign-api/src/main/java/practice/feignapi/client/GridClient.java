package practice.feignapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import practice.common.Result;
import practice.entity.Grid;

@FeignClient("area-service")
public interface GridClient {
    @GetMapping("/grids")
    Result getGrids();

    @GetMapping("/grids/{id}")
    Result getGridById(@PathVariable Integer id);

    @PostMapping("/grids")
    Result addGrid(@RequestBody Grid grid);

    @PutMapping("/grids")
    Result updateGrid(@RequestBody Grid grid);

    @DeleteMapping("/grids/{id}")
    Result deleteGrid(@PathVariable Integer id);
}
