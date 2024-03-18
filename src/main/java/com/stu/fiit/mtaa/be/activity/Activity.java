package com.stu.fiit.mtaa.be.activity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Activity {
    @Id
    @SequenceGenerator(
            name = "activity_sequence",
            sequenceName = "activity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "activity_sequence"
    )
    private Long id;
    @Column(
            nullable = false
    )
    private Long user_id;


    private Double distance;
    private Double duration;
    private Integer calories;
    private String mapRoute;
    private Boolean shared;
    private String title;
    private String body;
    private Date created_at;


}