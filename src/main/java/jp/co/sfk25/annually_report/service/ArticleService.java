package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
