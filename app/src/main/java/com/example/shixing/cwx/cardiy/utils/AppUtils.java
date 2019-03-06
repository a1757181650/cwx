package com.example.shixing.cwx.cardiy.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.jinglangtech.cardiy.AppApplication;

import java.util.List;

/**
 * Created by hss on 2016/12/11.
 */

public class AppUtils {

    public static Toast toast;

    public static Context getContext() {
        return AppApplication.getInstance();
    }

    public static Thread getMainThread() {
        return AppApplication.getMainThread();
    }

    public static long getMainThreadId() {
        return AppApplication.getMainThreadId();
    }

    public static ConnectivityManager cm;

    static {
        cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static int getStatusHeight(Activity activity) {
        int statusHeight = 0;
        Rect localRect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        statusHeight = localRect.top;
        if (0 == statusHeight) {
            Class<?> localClass;
            try {
                localClass = Class.forName("com.android.internal.R$dimen");
                Object localObject = localClass.newInstance();
                int i5 = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
                statusHeight = activity.getResources().getDimensionPixelSize(i5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return statusHeight;
    }

    /**
     * 获取版本名
     */
    public static String getVersion() {
        try {
            PackageInfo pi = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            return pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取版本号
     */
    public static int getVersionCode() {
        try {
            PackageInfo pi = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            return pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * dip转换px
     */
    public static int dip2px(int dip) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * px转换dip
     */
    public static int px2dip(int px) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 获取主线程的handler
     */
    public static Handler getHandler() {
        return AppApplication.getMainThreadHandler();
    }

    /**
     * 延时在主线程执行runnable
     */
    public static boolean postDelayed(Runnable runnable, long delayMillis) {
        return getHandler().postDelayed(runnable, delayMillis);
    }

    /**
     * 在主线程执行runnable
     */
    public static boolean post(Runnable runnable) {
        return getHandler().post(runnable);
    }

    /**
     * 从主线程looper里面移除runnable
     */
    public static void removeCallbacks(Runnable runnable) {
        getHandler().removeCallbacks(runnable);
    }

    public static View inflate(@LayoutRes int resId) {
        return LayoutInflater.from(getContext()).inflate(resId, null);
    }

    /**
     * 获取资源
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 获取文字
     */
    public static String getString(@StringRes int resId) {
        return getResources().getString(resId);
    }

    /**
     * 获取文字数组
     */
    public static String[] getStringArray(@ArrayRes int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 获取dimen
     */
    public static int getDimens(@DimenRes int resId) {
        return getResources().getDimensionPixelSize(resId);
    }

    /**
     * 获取drawable
     */
    @SuppressWarnings("deprecation")
    public static Drawable getDrawable(@DrawableRes int resId) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getResources().getDrawable(resId, null);
        } else {
            return getResources().getDrawable(resId);
        }
    }

    /**
     * 获取颜色
     */
    @SuppressWarnings("deprecation")
    public static int getColor(@ColorRes int resId) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getResources().getColor(resId, null);
        } else {
            return getResources().getColor(resId);
        }
    }

    /**
     * 获取颜色选择器
     */
    @SuppressWarnings("deprecation")
    public static ColorStateList getColorStateList(@ColorRes int resId) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getResources().getColorStateList(resId, null);
        } else {
            return getResources().getColorStateList(resId);
        }
    }

    //判断当前的线程是不是在主线程
    public static boolean isRunInMainThread() {
        return android.os.Process.myTid() == getMainThreadId();
    }

    public static void runInMainThread(Runnable runnable) {
        if (isRunInMainThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    /**
     * 对toast的简易封装。线程安全，可以在非UI线程调用。
     */
    public static void showToastSafe(@StringRes final int resId) {
        showToastSafe(getString(resId));
    }

    /**
     * 对toast的简易封装。线程安全，可以在非UI线程调用。
     */
    public static void showToastSafe(final String str) {
        if (isRunInMainThread()) {
            showToast(str, Toast.LENGTH_SHORT);
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    showToast(str, Toast.LENGTH_SHORT);
                }
            });
        }
    }

    /**
     * 对toast的简易封装。线程安全，可以在非UI线程调用。
     */
    public static void showToastSafe(final String str, final int duration) {
        if (isRunInMainThread()) {
            showToast(str, duration);
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    showToast(str, duration);
                }
            });
        }
    }

    private static void showToast(String str, int duration) {
        if (toast == null) {
            toast = Toast.makeText(getContext(), str, duration);
        } else {
            toast.setText(str);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    /**
     * 拨打电话号码
     *
     * @param number 电话号码
     */
    public static void callTel(String number) {
        /*AppBaseActivity activity = AppBaseActivity.getForegroundActivity();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        activity.startActivity(intent);*/
    }

    /**
     * 发送短信
     *
     * @param phoneNumber 电话号码
     * @param message     消息内容
     */
    public static void sendSMS(String phoneNumber, String message) {
        //获取短信管理器
        android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
        //拆分短信内容（手机短信长度限制）
        List<String> divideContents = smsManager.divideMessage(message);
        for (String text : divideContents) {
            smsManager.sendTextMessage(phoneNumber, null, text, null, null);
        }
    }

    @SuppressWarnings("deprecation")
    public static int getDisplayWidth() {
        int width;
        Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealMetrics(metrics);
            width = metrics.widthPixels;
        } else {
            width = display.getWidth();
        }
        return width;
    }

    @SuppressWarnings("deprecation")
    public static int getDisplayHeight() {
        int height;
        Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealMetrics(metrics);
            height = metrics.heightPixels;
        } else {
            height = display.getHeight();
        }
        return height;
    }

    /**
     * 判断网络是否可用
     */
    public static Boolean isNetworkReachable() {
        NetworkInfo current = cm.getActiveNetworkInfo();
        return current != null && (current.isAvailable());
    }
}
