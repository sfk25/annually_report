package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.controller.model.AuthResult;
import jp.co.sfk25.annually_report.form.LoginInfo;
import jp.co.sfk25.annually_report.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 認証
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class LoginController {

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
            @RequestBody LoginInfo loginInfo, HttpServletRequest request, HttpServletResponse response){

        // 認証処理を実行
        AuthResult authResult = loginService.login(loginInfo);

        // 認証OKの場合はcsrfトークンをクッキーにセット
        if(authResult.getName() != null){
            CsrfToken csrf = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
            if(csrf != null){
                Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                String token = csrf.getToken();
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if((cookie == null || token != null && !token.equals(cookie.getValue()))
                        && (authentication != null && authentication.isAuthenticated())){
                    cookie = new Cookie("XSRF-TOKEN", token);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
            return new ResponseEntity<>(authResult,null, HttpStatus.OK);
        }else{
            // 認証失敗
            return new ResponseEntity<>(authResult,null,HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * ログアウト
     */
    @PostMapping(value = "/logout")
    public void logout(HttpServletRequest request){
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
    public boolean init(){
        return true;
    }
}
