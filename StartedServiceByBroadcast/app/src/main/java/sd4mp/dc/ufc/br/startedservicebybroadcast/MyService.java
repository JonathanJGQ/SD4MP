package sd4mp.dc.ufc.br.startedservicebybroadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by 0322850 on 15/04/15.
 */
public class MyService extends Service{

    static boolean running = true;

    public void onCreate(){
        Log.i("ServiceCat", " -> OnCreate()");
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
        running = false;
    }

    public void run(){
        int i=0;

        while(running){
            Log.i("MyService","Espera ocupada");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){

            }
        }
        running = false;
    }
}
