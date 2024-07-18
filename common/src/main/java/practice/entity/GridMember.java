package practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("grid_members")
public class GridMember extends User{
    private Integer id;
    private Integer userId;
    private Integer taskNum;
    private String provinceId;
    private String cityId;
    private Integer state;
}
