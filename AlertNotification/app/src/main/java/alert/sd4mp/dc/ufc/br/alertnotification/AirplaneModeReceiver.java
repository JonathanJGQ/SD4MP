package alert.sd4mp.dc.ufc.br.alertnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by 0322850 on 06/04/15.
 */
public class AirplaneModeReceiver extends BroadcastReceiver{

    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "Modo Avião.", Toast.LENGTH_LONG).show();
    }
}
