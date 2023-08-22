package com.prueba.fonyou.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    @Id
    @Column(name = "ID_EXAM")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "MY_ENTITY_SEQ", allocationSize = 1)
    private Long idExam;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Question> questionList;

    @OneToOne(mappedBy = "exam")
    private Assignment assignment;
}
