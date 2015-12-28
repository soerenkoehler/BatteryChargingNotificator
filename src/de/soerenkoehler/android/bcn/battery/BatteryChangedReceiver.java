package de.soerenkoehler.android.bcn.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import de.soerenkoehler.android.bcn.notifications.BatteryNotificator;

public class BatteryChangedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
            new BatteryNotificator(context).notificationsFor(new BatteryInformation(intent));
        }
    }
}
