package mymail.sd4mp.dc.ufc.br.mymail;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EmailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_email, menu);
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

    public void enviarEmail(View view){

        EditText para = (EditText) findViewById(R.id.editText);
        EditText assunto = (EditText) findViewById(R.id.editText2);
        EditText conteudo = (EditText) findViewById(R.id.editText3);

        if(para.getText().toString().equals("")){
            Toast.makeText(this, "Preencha o campo de destinatário.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(assunto.getText().toString().equals("")){
            Toast.makeText(this, "Preencha o campo de assunto.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(conteudo.getText().toString().equals("")){
            Toast.makeText(this, "Preencha o conteudo do email.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"",para.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT,assunto.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,conteudo.getText().toString());
        startActivity(Intent.createChooser(intent,"Send Email"));
    }

    public void cancelar(View view){
        Toast.makeText(this, "Email Cancelado.", Toast.LENGTH_SHORT).show();
        finish();;
        return;
    }
}
