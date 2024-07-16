package practice.areaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.areaservice.service.GridService;

@RestController
@RequestMapping("/grids")
public class GridController {
    @Autowired
    private GridService gridService;
}
