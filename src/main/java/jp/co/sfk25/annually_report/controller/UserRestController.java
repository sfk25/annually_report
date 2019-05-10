package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.controller.model.UserModel;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.form.UserRegister;
import jp.co.sfk25.annually_report.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserRestController {
    private final UserService userService;

    @GetMapping(path = "")
    public List<User> getAll() {
        return userService.getUsers();
    }

    @PostMapping(path = "/register")
    public boolean register(@RequestBody @Validated UserRegister userRegister, BindingResult bindingResult) throws Exception {

        // TODO エラーハンドリング修正

        if (bindingResult.hasErrors()) {
            throw new Exception("入力した値を確認してください");
        }

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRegister, userModel);

        if (!userService.canRegister(userModel.getName(), userModel.getEmail())) {
            throw new Exception("名前かメールアドレスが既に登録されています");
        }

        userService.register(userModel);

        return true;
    }
}
