package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "offices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "address_line1", length = 50)
    private String addressLine1;

    @Column(name = "address_line2", length = 50)
    private String addressLine2;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "postal_code", length = 15)
    private String postalCode;

    @Column(name = "territory", length = 10)
    private String territory;
}
