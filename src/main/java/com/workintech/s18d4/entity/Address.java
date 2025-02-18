package com.workintech.s18d4.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address", schema = "fsweb")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "street")
    private String street;


    @Column(name = "no")
    private int no;


    @Column(name = "city")
    private String city;


    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "address",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    private Customer customer;

}
