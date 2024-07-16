package practice.entity;

import lombok.Data;

@Data
public class Aqi {
    private Integer id;
    private Integer aqiId;
    private String chineseExplain;
    private String aqiExplain;
    private String color;
    private String healthImpact;
    private String suggestions;
    private Double so2Min;
    private Double so2Max;
    private Double coMin;
    private Double coMax;
    private Double spmMin;
    private Double spmMax;
    private String remarks;
}