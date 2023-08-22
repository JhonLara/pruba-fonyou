package com.prueba.fonyou.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "ID_STUDENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "MY_ENTITY_SEQ", allocationSize = 1)
    private Long idStudent;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Long age;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIME_ZONE")
    private TimeZoneEnum timeZone;

    @Column(name = "BUY_VALUE")
    private String city;

    @OneToOne()
    private Assignment assignment;
}
