package com.olsproject.onlinelotterysystem.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @SequenceGenerator(name = "id_sequence",
    sequenceName = "id_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "id_sequence")
    private int id;
   // @Column(unique = true,nullable = false)
    private Long PersonalIdNo;
    private String name;
    private String mobileNo;
    private String emailId;
    boolean participate=true;
}
