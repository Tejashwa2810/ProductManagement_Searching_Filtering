package com.example.productcatalog.Service;

import com.example.productcatalog.Exceptions.LoginException;
import com.example.productcatalog.Repository.LoginRepository;
import com.example.productcatalog.models.Login;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public boolean getLogin(String username, String password) {
        Login login = loginRepository.getLogin(username, password);

        if (login != null) {
            return true;
        }

        throw new LoginException("Invalid login credentials!!!");
    }
}
