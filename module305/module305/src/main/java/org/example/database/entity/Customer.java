package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name", length = 50)
    private String customerName;

    @Column(name = "contact_firstname", length = 50)
    private String contactFirstname;

    @Column(name = "contact_lastname", length = 50)
    private String contactLastname;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "address_line1", length = 50)
    private String addressLine1;

    @Column(name = "address_line2", length = 50)
    private String addressLine2;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "postal_code", length = 50)
    private String postalCode;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "sales_rep_employee_id", length = 50)
    private Integer salesRepEmployeeId;

    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private Double creditLimit;
}
