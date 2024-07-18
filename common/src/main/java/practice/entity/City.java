package practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cities")
public class City {
    private Integer id;
    private String name;
    private Integer provinceId;
    private String provinceName;
}
