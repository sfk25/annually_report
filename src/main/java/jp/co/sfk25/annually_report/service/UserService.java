package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.controller.model.UserModel;
import jp.co.sfk25.annually_report.domain.entity.Group;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final GroupService groupService;
    private final PasswordEncoder passwordEncoder;

    public UserModel getUser(int useId) {
        return convertToModel(userRepository.findOne(useId));
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


    public UserModel convertToModel(User user) {
        UserModel userModel = new UserModel();

        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());

        Group group = groupService.getGroup(user.getGroupId());
        userModel.setGroupName(group.getValue());

        userModel.setEnteringCompanyDate(user.getEnteringCompanyDate());
        userModel.setSex(user.getSex());
        userModel.setBloodType(user.getBloodType());
        userModel.setBirthday(user.getBirthday());
        userModel.setSelfIntroduction(user.getSelfIntroduction());

        return userModel;
    }
}
