package practice.areaservice.service;

import practice.entity.City;

import java.util.List;

public interface CityService {
    List<City> getAll();

    City getCityById(Integer id);

    Integer addCity(City city);

    Integer updateCity(City city);

    Integer deleteCity(Integer id);
}
