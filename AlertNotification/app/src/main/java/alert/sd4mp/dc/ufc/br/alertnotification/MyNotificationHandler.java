package alert.sd4mp.dc.ufc.br.alertnotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by JonathanGQ on 14/04/2015.
 */
public class MyNotificationHandler extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NotificationManager manager;
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(R.string.app_name);
        Toast.makeText(getApplicationContext(), "Notification Handled!!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
