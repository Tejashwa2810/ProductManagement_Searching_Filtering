package com.example.productcatalog.Controller;

import com.example.productcatalog.Service.LoginService;
import com.example.productcatalog.models.Login;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/product/login")
    public RedirectView getLogin(@RequestParam(value = "username", required = true, defaultValue = "") String username, @RequestParam(value = "password", required = true, defaultValue = "") String password) {
        Boolean login = loginService.getLogin(username, password);

        if(login){
            return new RedirectView("https://example.com");  // for different url
        }
        return new RedirectView("/auth/register?error=" + "Failed to login");
    }
}
