package com.example.shopspring.services.user;

import com.example.shopspring.representations.User;
import com.example.shopspring.services.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class UserValidator implements Validator {

    private UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "message.loginform.required");
        if(user.getUsername().length() > 32) {
            errors.rejectValue("username", "message.loginform.size.username");
        }

        if(userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "message.loginform.duplicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "message.loginform.required");

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("username", "message.loginform.size.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("username", "message.loginform.different.password");
        }
    }
}
