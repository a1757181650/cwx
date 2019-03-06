package com.example.shixing.cwx.cardiy;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018-1-15.
 */

public class AppApplication extends Application {
    private static String TAG = "AppApplication";

    /**
     * Application实例
     */
    private static AppApplication instance = null;
    private List<Activity> mActivityStack = new LinkedList<>();
    private RequestQueue mRequestQueue = null;

    private static int mMainThreadId = -1;
    private static Thread mMainThread;
    private static Handler mMainThreadHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mRequestQueue = Volley.newRequestQueue(this, null);
        Fresco.initialize(this);

    }

    public static AppApplication getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this, null);
        }
        return mRequestQueue;
    }

    public void addActivity(Activity activity) {
        mActivityStack.add(activity);
        //Logger.d("在activity栈中添加(" + activity.getClass().getSimpleName() + ")");
    }

    public void finishActivity(Activity activity) {
        if (mActivityStack.contains(activity)) {
            mActivityStack.remove(activity);
            //Logger.d("从activity栈中移除(" + activity.getClass().getSimpleName() + ")");
        }
    }

    public void finishAllActivity() {
        StringBuilder stringBuilder = new StringBuilder("移除所有的activity:");
        for (Activity activity : mActivityStack) {
            if (activity != null) {
                stringBuilder.append("==").append(activity.getClass().getSimpleName()).append("==");
                activity.finish();
            }
        }
        Log.d(TAG, stringBuilder.toString());
        mActivityStack.clear();
    }

    public void toTopActivity(){
        for (int i = 2; i <= mActivityStack.size(); i++) {
            if (mActivityStack.get(i - 1) != null) {
                mActivityStack.get(i - 1).finish();
            }
        }
        mActivityStack.clear();
    }

    public void finishOtherActivity() {
        for (int i = 1; i < mActivityStack.size(); i++) {
            if (mActivityStack.get(i - 1) != null) {
                mActivityStack.get(i - 1).finish();
            }
        }
        mActivityStack.clear();
    }

    public void finishLastActivity() {
        if (mActivityStack.get(mActivityStack.size() - 2) != null) {
            mActivityStack.get(mActivityStack.size() - 2).finish();
        }
    }

    public Activity getCurretActivity() {
        return mActivityStack.get(mActivityStack.size() - 1);
    }


    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

}
