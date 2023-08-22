package com.prueba.fonyou.entity;

import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @Column(name = "ID_QUESTION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "MY_ENTITY_SEQ", allocationSize = 1)
    private Long idQuestion;

    @Column(name = "STATEMENT")
    private String statement;

    @Column(name = "CORRECT_RESPONSE")
    private Character correct_response;

    @ElementCollection
    @Column(name = "ANSWERS")
    private Map<Character, String> answers;

    @Column(name = "SCORE")
    private Long score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_EXAM")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Exam exam;

}
