package practice.aqiservice.service;

import practice.entity.Aqi;

import java.util.List;

public interface AqiService {
    List<Aqi> getAqiList();

    Aqi getAqiById(Integer id);

    Integer addAqi(Aqi aqi);

    Integer updateAqi(Aqi aqi);

    Integer deleteAqi(Integer id);
}
