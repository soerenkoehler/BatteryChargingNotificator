package de.soerenkoehler.android.bcn.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PowerChangedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
            context.startService(new Intent(context, BatteryChangedService.class));
        } else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
            context.stopService(new Intent(context, BatteryChangedService.class));
        }
    }
}
