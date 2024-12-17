package com.example.module309.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCustomerFormBean {

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

    private String creditLimit;

}
