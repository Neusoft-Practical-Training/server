package practice.aqiservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.aqiservice.mapper.AqiMapper;
import practice.aqiservice.service.AqiService;
import practice.entity.Aqi;

import java.util.List;

@Service
public class AqiServiceImpl implements AqiService {
    @Autowired
    private AqiMapper aqiMapper;

    @Override
    public List<Aqi> getAqiList() {
        return aqiMapper.selectList(null);
    }

    @Override
    public Aqi getAqiById(Integer id) {
        return aqiMapper.selectById(id);
    }

    @Override
    public Integer addAqi(Aqi aqi) {
        return aqiMapper.insert(aqi);
    }

    @Override
    public Integer updateAqi(Aqi aqi) {
        return aqiMapper.updateById(aqi);
    }

    @Override
    public Integer deleteAqi(Integer id) {
        return aqiMapper.deleteById(id);
    }
}
