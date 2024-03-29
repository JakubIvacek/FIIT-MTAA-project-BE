package com.stu.fiit.mtaa.be.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/activity")
public class ActivityController {
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

    // Return activities for user id
    @GetMapping(path = "/user/{userId}")
    public List<Activity> findUserActivities(@PathVariable("userId") Long userId){
        return activityService.getUserActivities(userId);
    }

    // Return specific Activity
    @GetMapping(path = "/{activityId}")
    public Activity findActivityById(@PathVariable("activityId") Long activityId){
        return activityService.findActivityById(activityId);
    }

    //Add activity
    @PostMapping
    public void addNewActivity(@RequestBody Activity activity){
        activityService.addNewActivity(activity);
    }

    //Delete activity
    @DeleteMapping(path = "/{activityId}")
    public void deleteActivity(@PathVariable("activityId") Long activityId){
        activityService.deleteActivity(activityId);
    }
}