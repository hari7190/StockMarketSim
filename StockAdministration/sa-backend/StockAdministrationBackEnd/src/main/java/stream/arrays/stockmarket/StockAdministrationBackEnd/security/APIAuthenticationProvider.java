package stream.arrays.stockmarket.StockAdministrationBackEnd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class APIAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    AdminUserRepository adminUserRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        AdminUser adminUser = adminUserRepository.findByUserName(username);

        if (adminUser.getUserName().equals(username) && adminUser.getPassword().equals(password)) {
            try {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new BadCredentialsException("authentication Failed");
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
