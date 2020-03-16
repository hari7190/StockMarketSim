package stream.arrays.stockmarket.StockAdministrationBackEnd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@ComponentScan("stream.arrays.stockmarket.StockAdministrationBackEnd")
public class SAAuthUserDetailsService implements UserDetailsService{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Herer");
        try {
            AdminUser adminUser = jdbcTemplate.queryForObject(
                    "SELECT id, company_Name, user_Name, password FROM Admin_user WHERE user_Name = '" + username + "';"
                    ,(rs, rowNum) -> new AdminUser(
                            rs.getLong("id")
                            ,rs.getString("company_name")
                            ,rs.getString("user_name")
                            ,rs.getString("password")
                    )
                );
            if (Objects.isNull(adminUser)) {
                throw new UsernameNotFoundException(username);
            }
            System.out.println(adminUser.getPassword());
            return new SAAuthUserPrincipal(adminUser);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
