package practice.areaservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.areaservice.mapper.CityMapper;
import practice.areaservice.service.CityService;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;
}
