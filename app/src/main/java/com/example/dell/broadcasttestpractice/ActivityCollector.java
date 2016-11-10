package com.example.dell.broadcasttestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/11/8.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addactivity(Activity activity){
        activities.add(activity);
    }

    public static void removeactivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activities
             ) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
