package de.ba.auth.auth.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectUrl = null;

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                System.out.println(authority.getAuthority());
                redirectUrl = "/api/admin/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_USER")) {
                redirectUrl = "/api/user/main";
            }
            else {
                throw new IllegalStateException("User has no role assigned");
            }
        }

        if (redirectUrl == null) {
            throw new IllegalStateException();
        }

        response.sendRedirect(redirectUrl);
    }
}
