package practice.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.common.Result;
import practice.entity.GridMember;
import practice.userservice.service.GridMemberService;

@RestController
@RequestMapping("/grid-member")
public class GridMemberController {
    @Autowired
    private GridMemberService gridMemberService;

    @GetMapping("/{id}")
    public Result getGridMember(@PathVariable Integer id) {
        Result.ResultBuilder builder = Result.builder();
        GridMember gridMember = gridMemberService.getById(id);
        return builder
                .code(Result.SUCCESS)
                .data(gridMember)
                .message("获取辖区网格员成功")
                .build();
    }


}
