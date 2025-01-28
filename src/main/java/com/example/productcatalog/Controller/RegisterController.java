package com.example.productcatalog.Controller;

import com.example.productcatalog.Service.RegisterService;
import com.example.productcatalog.models.Login;
import com.example.productcatalog.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/product/register")
    public Login register(@RequestBody Login login) {
        Login register = registerService.createRegister(login.getUsername(), login.getPassword());
        return register;
    }
}
