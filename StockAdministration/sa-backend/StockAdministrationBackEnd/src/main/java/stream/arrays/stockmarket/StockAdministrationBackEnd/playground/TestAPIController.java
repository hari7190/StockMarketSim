package stream.arrays.stockmarket.StockAdministrationBackEnd.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stream.arrays.stockmarket.StockAdministrationBackEnd.commons.BaseAPIController;
import stream.arrays.stockmarket.StockAdministrationBackEnd.security.AdminUser;
import stream.arrays.stockmarket.StockAdministrationBackEnd.security.SAAuthUserDetailsService;

import java.security.Principal;

@RestController
public class TestAPIController extends BaseAPIController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(method = RequestMethod.GET, path = "/ping")
    public Principal user(Principal user) {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM admin_user", Integer.class);
        System.out.println(result);
        return user;
    }


}
