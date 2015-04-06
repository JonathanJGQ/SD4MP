package alert.sd4mp.dc.ufc.br.alertnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 0322850 on 06/04/15.
 */
public class BateryChangeReceiver extends BroadcastReceiver{

    public void onReceive(Context context, Intent intent){
        Intent i = new Intent();
        i.setAction("android.intent.action.BATTERY_CHANGED");
        context.sendBroadcast(i);
    }
}
