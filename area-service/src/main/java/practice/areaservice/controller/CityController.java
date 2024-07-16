package practice.areaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.areaservice.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;
}
