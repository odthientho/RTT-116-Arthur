package com.example.module309.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserFormBean {
        private Integer id;

        @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email does not match its format.")
        @NotEmpty(message = "Email is required.")
        private String email;

        @Pattern(regexp = "[A-Za-z0-9]+", message = "Customer name must contain only letters, numbers.")
        @NotEmpty(message = "Password is required.")
        private String password;

        private String fullName;
}
