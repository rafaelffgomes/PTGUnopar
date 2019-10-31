package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ptgunopar.dynu.net.dados.DadosGlobais;

public class Email extends AppCompatActivity {

    private EditText Et_Email;
    private Button Bt_ProximoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        getSupportActionBar().hide();

        Et_Email = findViewById(R.id.Et_Email);
        Bt_ProximoEmail = findViewById(R.id.Bt_ProximoEmail);
    }

    public void Proximo(View view) {
        String Email = Et_Email.getText().toString();

        if (!Email.contains("@") || !Email.contains(".")) {
            Toast.makeText(Email.this, R.string.Email_Invalido, Toast.LENGTH_SHORT).show();
        } else {
            DadosGlobais dados = new DadosGlobais();
            dados.setEmail(Email);

            Intent abrirproximo = new Intent(Email.this, Senha.class);
            startActivity(abrirproximo);
        }
    }
}