package jp.co.sfk25.annually_report.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CsrfUtil {

    /**
     * CSRFトークンをクッキーにセット
     * @param request リクエスト
     * @param response レスポンス
     * @param checkAuthentication 認証済みを確認するかのフラグ
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, boolean checkAuthentication) {

        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

        if (csrf == null) {
            return;
        }

        Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
        String token = csrf.getToken();

        // 認証済みであるかの判定値
        boolean isAuthenticated = true;
        if (checkAuthentication) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            isAuthenticated = authentication != null && authentication.isAuthenticated();
        }

        if (cookie == null || !token.equals(cookie.getValue()) && isAuthenticated) {
            cookie = new Cookie("XSRF-TOKEN", token);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }
}
