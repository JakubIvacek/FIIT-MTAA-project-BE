package com.example.mta_be.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ActivityService {
    private ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }
    //Get User-id activities
    public List<Activity> getUserActivities(Long userId) {
        List<Activity> userActivities = activityRepository.findUserActivites(userId)
                .orElseThrow(() -> new IllegalStateException( "Activites for this id not found user_id : " + userId));
        return userActivities;
    }
    // Delete User activity
    public void deleteActivity(Long activityId) {
        //Check if present
        Activity activity = activityRepository.findActivityById(activityId)
                .orElseThrow(() -> new IllegalStateException( "Activity with this id not found"));
        //Delete if yes
        activityRepository.deleteActivity(activityId);
    }
    //Add new Activity
    public void addNewActivity(Activity activity) {
        activityRepository.save(activity);
    }
    //Search and get specific activity
    public Activity findActivityById(Long activityId) {
        return activityRepository.getReferenceById(activityId);
    }
}
