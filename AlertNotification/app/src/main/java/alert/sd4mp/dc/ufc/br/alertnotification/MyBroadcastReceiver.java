package alert.sd4mp.dc.ufc.br.alertnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by JonathanGQ on 14/04/2015.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent){
        MainActivity m = new MainActivity();
        if(intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
            if (m.v[0] == 1) {
                createNotification(1,context,"Notificação","Alerta de Notificação","Bateria Mudou");
            }
        }
        if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")) {
            if (m.v[1] == 1) {
                createNotification(2,context,"Notificação","Alerta de Notificação","Modo Avião Mudou");
            }
        }
        if(intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
            if (m.v[2] == 1) {
                createNotification(3,context,"Notificação","Alerta de Notificação","Bateria Conectada");
            }
        }
        if(intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            if (m.v[3] == 1) {
                createNotification(4,context,"Notificação","Alerta de Notificação","Bateria Desconectada");
            }
        }
    }

    protected void createNotification(int icon, Context context,String status, String title, String content){
        NotificationManager manager;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setTicker(status);
        builder.setContentTitle(title);
        builder.setContentText(content);
        if(icon == 1){
            builder.setSmallIcon(R.drawable.batery_change);
        }
        if(icon == 2){
            builder.setSmallIcon(R.drawable.airplane);
        }
        if(icon == 3){
            builder.setSmallIcon(R.drawable.batery_connected);
        }
        if(icon == 4){
            builder.setSmallIcon(R.drawable.batery_disconnected);
        }

        Intent intent = new Intent(context ,MyNotificationHandler.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, 0);
        builder.setContentIntent(pIntent);
        Notification notification = builder.build();
        manager.notify(R.string.app_name, notification);
;    }
}
