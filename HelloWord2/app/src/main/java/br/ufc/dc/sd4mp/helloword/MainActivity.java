package br.ufc.dc.sd4mp.helloword;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private static final String CATEGORIA = "CicloVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(CATEGORIA,getClassName() + ".onCreate() --> Created");
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
        return MainActivity.class.getName();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void startActivityExplicita(View view){
        Intent intent = new Intent(this,TargetActivity.class);
        startActivity(intent);
    }

    public void startActivityImplicita(View view){
        Intent intent = new Intent();
        intent.setAction("br.ufc.dc.action.DELETAR");
        intent.addCategory("br.ufc.dc.category.PADRAO");
        startActivity(intent);

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
