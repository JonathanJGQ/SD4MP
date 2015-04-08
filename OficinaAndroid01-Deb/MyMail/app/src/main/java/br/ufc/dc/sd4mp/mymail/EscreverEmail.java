package br.ufc.dc.sd4mp.mymail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Debora on 06/04/2015.
 */
public class EscreverEmail extends Activity {

    private EditText dest,subject,content;
    private Button send,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writemail);

        dest = (EditText)findViewById(R.id.etDest);
        subject = (EditText)findViewById(R.id.etSubj);
        content = (EditText)findViewById(R.id.etContent);
    }

    public void enviarMail(View v)
    {
        String email = dest.getText().toString();
        String assunto = subject.getText().toString();
        String corpo = content.getText().toString();

        if(email.equals("") || assunto.equals("") || corpo.equals(""))
        {
            Toast.makeText(this,"Preencha todos os campos!",Toast.LENGTH_SHORT).show();
        }
        else{

            Intent it = new Intent(Intent.ACTION_SEND);

            it.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
            it.putExtra(Intent.EXTRA_SUBJECT, assunto);
            it.putExtra(Intent.EXTRA_TEXT,corpo);
            it.setType("plain/text");
            startActivity(Intent.createChooser(it,"Enviar email..."));
        }

    }

    public void cancelMail(View v)
    {
        Toast.makeText(this,"O email foi descartado!",Toast.LENGTH_SHORT).show();
        finish();
    }
}
