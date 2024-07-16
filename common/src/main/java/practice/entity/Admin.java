package practice.entity;

import lombok.Data;

@Data
public class Admin extends User {
    private Integer id;
    private Integer userId;
    private String provinceId;
    private String cityId;
    private Integer permission;
}
