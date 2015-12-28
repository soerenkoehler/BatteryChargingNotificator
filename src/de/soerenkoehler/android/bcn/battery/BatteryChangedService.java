package de.soerenkoehler.android.bcn.battery;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class BatteryChangedService extends Service {

    private BatteryChangedReceiver batteryChangedReceiver = new BatteryChangedReceiver();

    @Override
    public void onCreate() {
        registerReceiver(batteryChangedReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(batteryChangedReceiver);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
