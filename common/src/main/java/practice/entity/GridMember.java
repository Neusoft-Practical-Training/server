package practice.entity;

import lombok.Data;

@Data
public class GridMember extends User{
    private Integer id;
    private Integer userId;
    private Integer taskNum;
    private String provinceId;
    private String cityId;
    private Integer state;
}
