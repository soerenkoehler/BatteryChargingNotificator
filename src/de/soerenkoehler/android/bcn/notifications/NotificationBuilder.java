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
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import de.soerenkoehler.android.bcn.R;

public class NotificationBuilder {
    private int title;
    private int text;
    private int icon;
    private int flags;
    private boolean light;

    private Context context;

    public NotificationBuilder(Context context) {
        this.context = context;
    }

    public Notification aChargingNotification() {
        return withTitle(R.string.charging_title).withText(R.string.charging_text)
            .withFlags(Notification.FLAG_NO_CLEAR | Notification.FLAG_ONGOING_EVENT | Notification.FLAG_ONLY_ALERT_ONCE)
            .withIcon(R.drawable.battery_orange)
            .create();
    }

    public Notification aChargedNotification() {
        return withTitle(R.string.charged_title).withText(R.string.charged_text)
            .withFlags(Notification.FLAG_AUTO_CANCEL | Notification.FLAG_ONLY_ALERT_ONCE)
            .withIcon(R.drawable.battery_green)
            .withLight()
            .create();
    }

    public NotificationBuilder withTitle(int title) {
        this.title = title;
        return this;
    }

    public NotificationBuilder withText(int text) {
        this.text = text;
        return this;
    }

    public NotificationBuilder withIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public NotificationBuilder withFlags(int flags) {
        this.flags = flags;
        return this;
    }

    public NotificationBuilder withLight() {
        this.light = true;
        return this;
    }

    public Notification create() {
        Intent notificationIntent = new Intent(context, DummyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        Notification notification = new Notification(icon, context.getText(title), System.currentTimeMillis());
        notification.setLatestEventInfo(context, context.getText(title), context.getText(text), pendingIntent);

        notification.defaults = 0;
        notification.flags = flags;

        if (light) {
            notification.defaults = 0;
            notification.ledARGB = Color.WHITE;
            notification.ledOnMS = 1000;
            notification.ledOffMS = 0;
            notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        }

        return notification;
    }
}
