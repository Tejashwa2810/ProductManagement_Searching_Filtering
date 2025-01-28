package com.example.productcatalog.Service;

import com.example.productcatalog.Exceptions.LoginException;
import com.example.productcatalog.Repository.RegisterRepository;
import com.example.productcatalog.models.Login;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public Login createRegister(String username, String password) {
        if (registerRepository.existsByUsername(username)) {
            throw new LoginException("Username already exists");
        }
        Login register = new Login();
        register.setUsername(username);
        register.setPassword(password);
        return registerRepository.save(register);
    }
}

