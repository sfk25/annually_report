package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserRestController {
    private final UserService userService;

    @GetMapping(path = "")
    public List<User> getAll() {
        return userService.getUsers();
    }
}
