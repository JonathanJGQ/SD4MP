package br.ufc.dc.sd4mp.mymap;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

/**
 * Created by 0322850 on 25/05/15.
 */
public class MySensor extends Activity implements SensorEventListener{

    private SensorManager manager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = manager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    @Override
    public void onResume(){
        super.onResume();
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event){

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}
