package sd4mp.dc.ufc.br.startedservicebybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * Created by 0322850 on 15/04/15.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent){
        Intent i = new Intent(context,MyService.class);
        context.startService(i);

    }
}
