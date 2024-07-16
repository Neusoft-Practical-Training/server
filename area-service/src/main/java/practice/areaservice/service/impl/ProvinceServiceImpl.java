package practice.areaservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.areaservice.mapper.ProvinceMapper;
import practice.areaservice.service.ProvinceService;
import practice.entity.Province;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> getAllProvinces() {
        return provinceMapper.selectList(null);
    }

    @Override
    public Province getProvinceById(Integer id) {
        return provinceMapper.selectById(id);
    }

    @Override
    public Integer addProvince(Province province) {
        return provinceMapper.insert(province);
    }

    @Override
    public Integer updateProvince(Province province) {
        return provinceMapper.updateById(province);
    }

    @Override
    public Integer deleteProvinceByID(Integer id) {
        return provinceMapper.deleteById(id);
    }
}
