package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.controller.model.UserModel;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // TODO UserModelのリストにして返す
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserModel getUser(int userId) {
        return convertToModel(userRepository.findOne(userId));
    }

    public boolean canRegister(String name, String email) {
        return userRepository.findByUserName(name) == null && userRepository.findByEmail(email) == null;
    }

    public void insert(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.insert(userModel);
    }

    public void update(UserModel userModel) {
        userRepository.update(userModel);
    }


    private UserModel convertToModel(User user) {
        UserModel userModel = new UserModel();

        if (user != null) {
            userModel.setId(user.getId());
            userModel.setName(user.getName());
            userModel.setEmail(user.getEmail());
            userModel.setGroupId(user.getGroupId());

            Timestamp enteringCompanyDate = user.getEnteringCompanyDate() != null
                    ? Timestamp.valueOf(user.getEnteringCompanyDate())
                    : null;
            userModel.setEnteringCompanyDate(enteringCompanyDate);

            userModel.setSex(user.getSex());
            userModel.setBloodType(user.getBloodType());

            Timestamp birthday = user.getBirthday() != null
                    ? Timestamp.valueOf(user.getBirthday())
                    : null;
            userModel.setBirthday(birthday);

            userModel.setSelfIntroduction(user.getSelfIntroduction());
        }

        return userModel;
    }
}
