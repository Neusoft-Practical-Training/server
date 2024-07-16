package practice.areaservice.service;

import practice.entity.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> getAllProvinces();

    Province getProvinceById(Integer id);

    Integer addProvince(Province province);

    Integer updateProvince(Province province);

    Integer deleteProvinceByID(Integer id);
}
