package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsServiceの実装クラス
 * Spring Securityでのユーザー認証に使用する
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /* (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 認証を行うユーザー情報を格納する
        User user = null;

        try {
            // 入力したユーザーIDから認証を行うユーザー情報を取得する
            user = userRepository.findByEmail(email);
        } catch (Exception e) {
            // 取得時にExceptionが発生した場合
            throw new UsernameNotFoundException("It can not be acquired User");
        }

        // ユーザー情報を取得できなかった場合
        if (user == null) {
            throw new UsernameNotFoundException("User not found for login id: " + email);
        }

        // ユーザー情報が取得できたらSpring Securityで認証できる形で戻す
        return user;
    }

}