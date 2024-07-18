package practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("aqi_feedbacks")
public class AqiFeedback {
    private Integer id;
    private Integer afId;
    private Integer supervisorId;
    private Integer pre_aqiId;
    private Integer aaId;
    private Integer state;
    private String gridId;
    private String address;
    private String afTime;
    private String afDate;
    private String explain;
    private String remarks;
}
