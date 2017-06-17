package org.co.thanhpd56.datecountdown;


import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import timber.log.Timber;
import org.co.thanhpd56.datecountdown.injection.CountdownComponent;
import org.co.thanhpd56.datecountdown.injection.CountdownModule;
import org.co.thanhpd56.datecountdown.injection.DaggerCountdownComponent;

public class CountdownApplication extends Application {

    private final CountdownComponent countDownComponent = createCountdownComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());//TODO Install a Crashlytics tree in production
        }
    }

    protected CountdownComponent createCountdownComponent() {
        return DaggerCountdownComponent.builder()
                .countdownModule(new CountdownModule(this))
                .build();
    }

    public CountdownComponent getCountDownComponent() {
        return countDownComponent;
    }

}
