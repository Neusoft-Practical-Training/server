package practice.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.common.Result;
import practice.entity.Admin;
import practice.entity.AqiAssignment;
import practice.userservice.service.AdminService;
import practice.userservice.service.AqiAssignmentService;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AqiAssignmentService aqiAssignmentService;

    @PostMapping("assign")
    public Result assignAdmin(@RequestBody AqiAssignment aqiAssignment) {
        Result.ResultBuilder builder = Result.builder();
        Integer assign = aqiAssignmentService.assign(aqiAssignment);

        if (assign == null || assign != 1) {
            return builder.code(0).message("指派任务失败，请重试").build();
        }
        return builder.code(1).message("指派任务成功").build();
    }

    @PostMapping("/{id}")
    public Result getAdmin(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();
        Admin admin = adminService.getById(id);
        if (admin == null) {
            return builder.code(Result.ERROR).message("获取辖区管理员失败").build();
        }
        return builder.code(1).data(Result.SUCCESS).message("获取辖区管理员成功").build();
    }
}