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
