package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.controller.model.UserModel;
import jp.co.sfk25.annually_report.domain.entity.Group;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.domain.repository.UserRepository;
import jp.co.sfk25.annually_report.appEnum.BloodTypeEnum;
import jp.co.sfk25.annually_report.appEnum.SexEnum;
import lombok.RequiredArgsConstructor;
import org.jooq.tools.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final GroupService groupService;
    private final PasswordEncoder passwordEncoder;

    public UserModel getUser(int userId) {
        return convertToModel(userRepository.findOne(userId));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean canRegister(String name, String email) {
        return userRepository.findByUserName(name) == null && userRepository.findByEmail(email) == null;
    }

    public void register(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.insert(userModel);
    }


    private UserModel convertToModel(User user) {
        UserModel userModel = new UserModel();

        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());

        Group group = groupService.getGroup(user.getGroupId());
        userModel.setGroupName(group.getValue());

        String enteringCompany =  user.getEnteringCompanyDate() != null
                ? user.getEnteringCompanyDate().format(DateTimeFormatter.ISO_LOCAL_DATE)
                : "未入力";
        userModel.setEnteringCompanyDate(enteringCompany);

        userModel.setSex(SexEnum.getValueByCode(user.getSex()).getValue());
        userModel.setBloodType(BloodTypeEnum.getValueByCode(user.getBloodType()).getValue());

        String birthDay =  user.getBirthday() != null
                ? user.getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE)
                : "未入力";
        userModel.setBirthday(birthDay);

        String selfIntroduction = !StringUtils.isEmpty(user.getSelfIntroduction())
                ? user.getSelfIntroduction()
                : "未入力";
        userModel.setSelfIntroduction(selfIntroduction);

        return userModel;
    }
}
