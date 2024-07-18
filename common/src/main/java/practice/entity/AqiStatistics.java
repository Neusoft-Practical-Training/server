package practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("aqi_statistics")
public class AqiStatistics {
    private Integer id;
    private Integer asId;
    private Integer aaId;
    private Integer gmId;
    private Integer confirmAqiId;
    private Integer so2Level;
    private Integer coLevel;
    private Integer spmLevel;
    private Double so2Value;
    private Double coValue;
    private Double spmValue;
    private String gridId;
    private String address;
    private String confirmDate;
    private String confirmTime;
    private String explain;
    private String remarks;
}
