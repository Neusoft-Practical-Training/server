package practice.areaservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.areaservice.mapper.CityMapper;
import practice.areaservice.service.CityService;
import practice.entity.City;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getAll() {
        return cityMapper.selectList(null);
    }

    @Override
    public City getCityById(Integer id) {
        return cityMapper.selectById(id);
    }

    @Override
    public Integer addCity(City city) {
        return cityMapper.insert(city);
    }

    @Override
    public Integer updateCity(City city) {
        return cityMapper.updateById(city);
    }

    @Override
    public Integer deleteCity(Integer id) {
        return cityMapper.deleteById(id);
    }
}
