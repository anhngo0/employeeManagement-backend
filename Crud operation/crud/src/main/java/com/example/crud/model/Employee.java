package com.example.crud.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_generator",
            sequenceName = "employee_generator",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_generator"
    )
    @Column(name = "id", nullable = false)
    private Long id ;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    public Employee(String firstname, String lastname, String email){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}
