package com.stu.fiit.mtaa.be.activity;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("SELECT activity FROM Activity activity WHERE activity.user_id = ?1")
    Optional<List<Activity>> findUserActivites(Long userId);

    @Query("SELECT activity FROM Activity activity WHERE activity.id = ?1")
    Optional<Activity> findActivityById(Long activityId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Activity activity WHERE activity.id = ?1")
    void deleteActivity(Long id);
}