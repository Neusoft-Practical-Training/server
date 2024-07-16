package practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class User {
    private Integer id;
    private String loginCode;
    private String password;
    private String tel;
    private String name;
    private Integer gender;
    private Integer role;
    private Integer age;
    private String remarks;
    private Boolean status;
    private String avatar;
    private String createTime;
    private String updateTime;
}
