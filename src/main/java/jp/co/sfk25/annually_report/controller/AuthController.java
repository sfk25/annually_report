package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.controller.model.AuthResult;
import jp.co.sfk25.annually_report.form.LoginInfo;
import jp.co.sfk25.annually_report.service.LoginService;
import jp.co.sfk25.annually_report.util.CsrfUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 認証
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    LoginService loginService;

    /**
     * ログイン
     * @param loginInfo
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseEntity<AuthResult> login(
            @RequestBody LoginInfo loginInfo, HttpServletRequest request, HttpServletResponse response) {

        // 認証処理を実行
        AuthResult authResult = loginService.login(loginInfo);

        if (authResult.getName() == null) {
            // 認証失敗
            return new ResponseEntity<>(authResult, null, HttpStatus.UNAUTHORIZED);
        }

        CsrfUtil.setCookie(request, response, true);

        return new ResponseEntity<>(authResult, null, HttpStatus.OK);
    }

    /**
     * ログアウト
     */
    @PostMapping(value = "/logout")
    public void logout(HttpServletRequest request) {
        try {
            request.logout();
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ログイン状態のチェック
     */
    @PostMapping(value = "/init")
    public boolean init() {
        return true;
    }
}
