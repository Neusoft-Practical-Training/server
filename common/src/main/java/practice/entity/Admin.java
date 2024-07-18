package practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admins")
public class Admin extends User {
    private Integer id;
    private Integer userId;
    private String provinceId;
    private String cityId;
    private Integer permission;
}
