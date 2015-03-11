package br.ufc.dc.sd4mp.helloword;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class TargetActivity extends ActionBarActivity {

    private static final String CATEGORIA = "CicloVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        Log.i(CATEGORIA, getClassName() + ".onCreate() --> Created");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(CATEGORIA,getClassName() + ".onDestroy() --> Destroyed");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(CATEGORIA,getClassName() + ".onPause() --> Paused");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(CATEGORIA,getClassName() + ".onRestart() --> Restarted");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(CATEGORIA,getClassName() + ".onResume() --> Resumed");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(CATEGORIA,getClassName() + ".onStart() --> Started");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(CATEGORIA,getClassName() + ".onStop() --> Stopped");
    }

    private String getClassName(){
        return TargetActivity.class.getName();
    }

    public void voltar(View view){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_target, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
