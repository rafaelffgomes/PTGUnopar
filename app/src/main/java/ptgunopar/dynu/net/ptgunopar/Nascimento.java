package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ptgunopar.dynu.net.dados.DadosGlobais;
import ptgunopar.dynu.net.utils.Mascara;

public class Nascimento extends AppCompatActivity {

    private EditText Et_Nascimento;
    private Button Bt_Proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nascimento);
        getSupportActionBar().hide();

        Et_Nascimento = findViewById(R.id.Et_Nascimento);
        Bt_Proximo = findViewById(R.id.Bt_ProximoNascimento);

        Et_Nascimento.addTextChangedListener(Mascara.mask(Et_Nascimento, Mascara.FORMAT_DATA));
    }

    public void Proximo(View view) {
        String Nascimento = Et_Nascimento.getText().toString();

        if (Nascimento.length() != 10) {
            Toast.makeText(Nascimento.this, R.string.Nascimento_Invalido, Toast.LENGTH_SHORT).show();
        } else {
            DadosGlobais dados = new DadosGlobais();
            dados.setNascimento(Nascimento);

            Intent abrirproximo = new Intent(Nascimento.this, TelefoneCelular.class);
            startActivity(abrirproximo);
        }
    }
}