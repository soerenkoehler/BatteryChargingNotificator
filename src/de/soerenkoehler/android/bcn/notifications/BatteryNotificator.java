package de.soerenkoehler.android.bcn.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import de.soerenkoehler.android.bcn.battery.BatteryInformation;

public class BatteryNotificator {

    private static final int ID_BATTERY_NOTIFICATION = 1;

    private NotificationManager notificationManager;
    private NotificationBuilder notificationBuilder;

    public BatteryNotificator(Context context) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationBuilder = new NotificationBuilder(context);
    }

    public void notificationsFor(BatteryInformation batteryInformation) {
        if (batteryInformation.isValid()) {
            if (batteryInformation.isPlugged()) {
                if (batteryInformation.isCharged()) {
                    showNotification(notificationBuilder.aChargedNotification());
                } else {
                    showNotification(notificationBuilder.aChargingNotification());
                }
            } else {
                hideNotification();
            }
        }
    }

    private void showNotification(Notification notification) {
        notificationManager.notify(ID_BATTERY_NOTIFICATION, notification);
    }

    private void hideNotification() {
        notificationManager.cancel(ID_BATTERY_NOTIFICATION);
    }
}
