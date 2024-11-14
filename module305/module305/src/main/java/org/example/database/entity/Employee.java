package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Corresponds to the 'id' column in the table
    private Integer id;

    @Column(name = "office_id")
    private Integer officeId; // Corresponds to the 'office_id' column

    @Column(name = "lastname")
    private String lastName; // Corresponds to the 'lastname' column

    @Column(name = "firstname")
    private String firstName; // Corresponds to the 'firstname' column

    @Column(name = "extension")
    private String extension; // Corresponds to the 'extension' column

    @Column(name = "email")
    private String email; // Corresponds to the 'email' column

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reports_to", nullable = false)
    @ToString.Exclude
    private Employee supervisor;

    @OneToMany(mappedBy = "supervisor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Employee> subordinates;

    @Column(name = "job_title")
    private String jobTitle; // Corresponds to the 'job_title' column

    @Column(name = "vacation_hours")
    private Integer vacationHours; // Corresponds to the 'vacation_hours' column

    @Column(name = "profile_image_url")
    private String profileImageUrl; // Corresponds to the 'profile_image_url' column

    @OneToMany(mappedBy = "repEmployee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Customer> customers;

}
