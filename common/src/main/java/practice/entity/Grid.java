package practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("grids")
public class Grid {
    private Integer id;
    private String name;
    private Integer cityId;
    private String cityName;
    private Integer provinceId;
    private String provinceName;
}
