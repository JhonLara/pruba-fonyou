package com.prueba.fonyou.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id
    @Column(name = "ID_ASSIGNMENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "MY_ENTITY_SEQ", allocationSize = 1)
    private Long idAnswer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_EXAM", referencedColumnName = "ID_EXAM")
    private Exam exam;

    @OneToOne(mappedBy = "assignment", cascade = CascadeType.ALL)
    private Student student;

    @ElementCollection
    @Column(name = "ANSWERS")
    private Map<Long, Character> answers;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIME_ZONE")
    private TimeZoneEnum timeZone;

    @Column(name = "ASSIGN_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDate date;

    @Column(name = "SCORE")
    private Long score;
}
