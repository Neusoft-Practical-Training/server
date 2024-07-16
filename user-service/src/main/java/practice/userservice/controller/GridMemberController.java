package practice.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.userservice.service.GridMemberService;

@RestController
@RequestMapping("/grid-member")
public class GridMemberController {
    @Autowired
    private GridMemberService gridMemberService;
}
