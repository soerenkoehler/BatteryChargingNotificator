package de.soerenkoehler.android.bcn.notifications;

import android.app.Activity;

public class DummyActivity extends Activity {
    @Override
    protected void onResume() {
        super.onResume();
        finish();
    }
}
