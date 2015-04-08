package sd4mp.dc.ufc.br.startedservicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by 0322850 on 08/04/15.
 */
public class MyService extends Service {

    public void onCreate(){
        Log.i("ServiceCat"," -> OnCreate()");
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("ServiceCat"," -> OnStartCommand()");
        return 1;
    }

    public IBinder onBind(Intent intent){
        Log.i("ServiceCat"," -> OnBind()");
        return null;
    }

    public void onDestroy(){
        Log.i("ServiceCat"," -> OnDestroy()");
    }

}
