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
