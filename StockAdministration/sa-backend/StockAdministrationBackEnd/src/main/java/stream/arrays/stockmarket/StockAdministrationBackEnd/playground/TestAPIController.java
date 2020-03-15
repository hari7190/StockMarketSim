package stream.arrays.stockmarket.StockAdministrationBackEnd.playground;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stream.arrays.stockmarket.StockAdministrationBackEnd.commons.BaseAPIController;

import java.security.Principal;

@RestController
public class TestAPIController extends BaseAPIController {
    @RequestMapping("/ping")
    public Principal user(Principal user) {
        return user;
    }
}
