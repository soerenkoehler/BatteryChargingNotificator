/*
 * Copyright 2015 Sören Köhler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
