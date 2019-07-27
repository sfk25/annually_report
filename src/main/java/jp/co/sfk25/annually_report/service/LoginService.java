package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.controller.model.AuthModel;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.form.LoginInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    @Autowired
    private AuthenticationManager authManager;


    /**
     * 認証処理
     * @param loginInfo
     * @return
     */
    public AuthModel login(LoginInfo loginInfo){
        Authentication authentication = null;
        AuthModel authResult = new AuthModel();

        try {
            // 照合実施
            Authentication request
                    = new UsernamePasswordAuthenticationToken(loginInfo.getEmail(), loginInfo.getPassword());

            // 対象ユーザが存在するか認証
            authentication = authManager.authenticate(request);

            // 認証OKの場合は認証結果をcontextholderに設定
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 認証済みユーザ情報を格納
            User principal = (User)authentication.getPrincipal();

            // クライアントへの返却データを設定
            authResult.setId(principal.getId());
            authResult.setName(principal.getUsername());
            authResult.setEmail(principal.getEmail());
        } catch (Exception e) {
            // TODO 失敗時の処理(エラーログ)
            System.out.println(e.toString());
        }
        return authResult;
    }

}



