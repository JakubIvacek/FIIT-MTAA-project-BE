package com.example.mta_be.activity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String body;
    private Date created_at;


    public Activity(Long user_id, Double distance, Double duration, Integer calories, String mapRoute, Boolean shared, String title, String body, Date created_at) {
        this.user_id = user_id;
        this.distance = distance;
        this.duration = duration;
        this.calories = calories;
        this.mapRoute = mapRoute;
        this.shared = shared;
        this.title = title;
        this.body = body;
        this.created_at = created_at;
    }

    public Activity(Long id, Long user_id, Double distance, Double duration, Integer calories, String mapRoute, Boolean shared, String title, String body, Date created_at) {
        this.id = id;
        this.user_id = user_id;
        this.distance = distance;
        this.duration = duration;
        this.calories = calories;
        this.mapRoute = mapRoute;
        this.shared = shared;
        this.title = title;
        this.body = body;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getMapRoute() {
        return mapRoute;
    }

    public void setMapRoute(String mapRoute) {
        this.mapRoute = mapRoute;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", distance=" + distance +
                ", duration=" + duration +
                ", calories=" + calories +
                ", mapRoute='" + mapRoute + '\'' +
                ", shared=" + shared +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    public Activity() {
    }
}
