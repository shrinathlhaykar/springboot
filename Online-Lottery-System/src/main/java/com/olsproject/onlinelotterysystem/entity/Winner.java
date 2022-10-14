package com.olsproject.onlinelotterysystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Winner {
//    @SequenceGenerator(name = "id_sequence",
//            sequenceName = "id_sequence")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//
//  generator = "id_sequence")
    @Id
    private Long id;
   // @Column(unique = true,nullable = false)
    private Long PersonalIdNo;
    private String name;
    private String mobileNo;
    private String emailId;
    private Date date;
    private int amount;
    private String position;
}
