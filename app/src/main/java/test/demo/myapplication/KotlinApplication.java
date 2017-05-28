package test.demo.myapplication;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import test.demo.myapplication.Utils.Utils;

/**
 * Created by challenger on 24/3/2017.
 */

public class KotlinApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public float getPixFromPd(int pd) {
        return Utils.convertDpToPixel(pd, this.getApplicationContext());
    }
}
