package com.example.module309.form;

import com.example.module309.database.entity.Employee;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCustomerFormBean {

    private Integer id;

    @Pattern(regexp = "[A-Za-z0-9\\s]+", message = "Customer name must contain only letters, numbers and spaces.")
    @Size(max = 50, message = "Customer name must be less than 50 characters")
    @NotEmpty(message = "Customer name is required.")
    private String customerName;

    @NotEmpty(message = "Firstname is required.")
    private String contactFirstname;

    @NotEmpty(message = "Lastname is required.")
    private String contactLastname;

    @NotEmpty(message = "Phone number is required.")
    private String phone;

    @NotEmpty(message = "Address is required.")
    private String addressLine1;

    private String addressLine2;

    @NotEmpty(message = "City is required.")
    private String city;

    private String state;

    private String postalCode;

    @NotEmpty(message = "Country is required.")
    private String country;

    private Double creditLimit;

    private Integer salesRepEmployeeId;

}
