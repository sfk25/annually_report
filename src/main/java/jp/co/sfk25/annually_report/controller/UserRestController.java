package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.controller.model.UserModel;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.form.UserRegister;
import jp.co.sfk25.annually_report.form.UserUpdate;
import jp.co.sfk25.annually_report.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jooq.tools.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    @GetMapping(path = "/detail/{id}")
    public UserModel get(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping(path = "/register")
    public boolean register(@RequestBody @Validated UserRegister userRegister, BindingResult bindingResult) throws Exception {

        // TODO エラーハンドリング修正

        if (bindingResult.hasErrors()) {
            throw new Exception("入力した値を確認してください");
        }

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRegister, userModel);

        // TODO Formクラス内のアノテーションでチェックするよう修正
        if (!userService.canRegister(userModel.getName(), userModel.getEmail())) {
            throw new Exception("名前かメールアドレスが既に登録されています");
        }

        userService.insert(userModel);

        return true;
    }

    @PostMapping(path = "/update")
    public boolean update(@RequestBody @Validated UserUpdate userUpdate, BindingResult bindingResult) throws Exception {

        // TODO エラーハンドリング修正

        if (bindingResult.hasErrors()) {
            throw new Exception("入力した値を確認してください");
        }

        userService.update(setUserModel(userUpdate));

        return true;
    }

    private UserModel setUserModel(UserUpdate userUpdate) {
        UserModel userModel = new UserModel();

        userModel.setId(userUpdate.getId());
        userModel.setName(userUpdate.getName());
        userModel.setEmail(userUpdate.getEmail());
        userModel.setGroupId(userUpdate.getGroupId());

        Timestamp enteringCompanyDate = !StringUtils.isEmpty(userUpdate.getEnteringCompanyDate())
                ? Timestamp.valueOf(userUpdate.getEnteringCompanyDate() + "00:00:00")
                : null;
        userModel.setEnteringCompanyDate(enteringCompanyDate);

        userModel.setSex(userUpdate.getSex());
        userModel.setBloodType(userUpdate.getBloodType());

        Timestamp birthday = !StringUtils.isEmpty(userUpdate.getBirthday())
                ? Timestamp.valueOf(userUpdate.getBirthday() + "00:00:00")
                : null;
        userModel.setEnteringCompanyDate(birthday);

        userModel.setSelfIntroduction(userUpdate.getSelfIntroduction());

        return userModel;
    }

}
