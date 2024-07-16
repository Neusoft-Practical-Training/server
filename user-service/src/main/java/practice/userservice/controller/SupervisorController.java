package practice.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.common.Result;
import practice.entity.Supervisor;
import practice.userservice.service.SupervisorService;

@RestController
@RequestMapping("/supervisors")
public class SupervisorController {
    @Autowired
    private SupervisorService supervisorService;

    @GetMapping("/{id}")
    public Result getSupervisor(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();
        Supervisor supervisor = supervisorService.getById(id);
        if (supervisor != null) {
            return builder
                    .code(Result.SUCCESS)
                    .data(supervisor)
                    .message("获取辖区公众监督员成功")
                    .build();
        }
        return builder
                .code(Result.ERROR)
                .message("获取辖区公众监督员失败")
                .build();
    }
}
