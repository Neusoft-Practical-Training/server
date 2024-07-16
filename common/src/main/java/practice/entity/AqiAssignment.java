package practice.entity;

import lombok.Data;

@Data
public class AqiAssignment {
    private Integer id;
    private Integer aaId;
    private Integer afId;
    private Integer asId;
    private Integer supervisorId;
    private Integer adminId;
    private Integer gmId;
    private Integer crossDomain;
    private Integer completed;
    private String gridId;
    private String address;
    private String assignDate;
    private String assignTime;
    private String remarks;
}