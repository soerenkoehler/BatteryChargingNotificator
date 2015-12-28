package de.soerenkoehler.android.bcn.battery;

import android.content.Intent;
import android.os.BatteryManager;

public class BatteryInformation {
    private boolean valid = false;
    private boolean plugged = false;
    private boolean charged = false;

    public BatteryInformation(Intent intent) {
        if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
            plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0) != 0;
            charged = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100) == intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            valid=true;
        }
    }

    public boolean isValid() {
        return valid;
    }

    public boolean isPlugged() {
        return plugged;
    }

    public boolean isCharged() {
        return charged;
    }
}
