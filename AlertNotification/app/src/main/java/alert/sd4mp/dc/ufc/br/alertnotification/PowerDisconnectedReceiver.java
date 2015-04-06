package alert.sd4mp.dc.ufc.br.alertnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 0322850 on 06/04/15.
 */
public class PowerDisconnectedReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent){
        Intent i = new Intent();
        i.setAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.sendBroadcast(i);
    }
}
