package stechtricker.notes.app.Activity;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import androidx.multidex.MultiDex;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.onesignal.OneSignal;

import java.util.Arrays;

import stechtricker.notes.app.R;
import stechtricker.notes.app.SharedPref.Setting;
import stechtricker.notes.app.SharedPref.SharedPref;

public class MyApplication extends Application {

    private SharedPref sharedPref;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPref = new SharedPref(this);
        if (sharedPref.getNightMode()) {
            Setting.Dark_Mode = true;
        } else {
            Setting.Dark_Mode = false;
        }

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(getApplicationContext());
        OneSignal.setAppId(getApplicationContext().getString(R.string.ONESIGNAL_APP_ID));

        // Initialize Facebook Audience Network
        AudienceNetworkAds.initialize(this);

        // Initialize Google Mobile Ads SDK
        MobileAds.initialize(this, initializationStatus -> {});

        // Configure test devices for Google Mobile Ads
        RequestConfiguration configuration = new RequestConfiguration.Builder()
                .setTestDeviceIds(Arrays.asList("0336997DCA346E1612B610471A578EEB"))
                .build();
        MobileAds.setRequestConfiguration(configuration);
    }
}
