package sd4mp.dc.ufc.br.startedservicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by 0322850 on 08/04/15.
 */
public class MyService extends Service implements Runnable{

    static boolean running = true;

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
        running = false;
    }

    public void run(){
        int i=0;

        while(running && i <=10){
            Log.i("("+ i++ +")MyService","MyService is running!!!");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){

            }
        }
        running = false;
    }
}
