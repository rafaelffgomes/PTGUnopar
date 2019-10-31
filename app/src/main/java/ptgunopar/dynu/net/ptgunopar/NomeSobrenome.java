package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ptgunopar.dynu.net.dados.DadosGlobais;

public class NomeSobrenome extends AppCompatActivity {

    private EditText Et_Nome;
    private EditText Et_SobreNome;
    private Button Bt_Proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_sobrenome);
        getSupportActionBar().hide();

        Et_Nome = findViewById(R.id.Et_Nome);
        Et_SobreNome = findViewById(R.id.Et_SobreNome);
        Bt_Proximo = findViewById(R.id.Bt_ProximoNomeSobrenome);
    }

    public void Proximo(View view) {
        String Nome = Et_Nome.getText().toString();
        String SobreNome = Et_SobreNome.getText().toString();

        if ((Nome.isEmpty()) || (SobreNome.isEmpty())) {
            Toast.makeText(NomeSobrenome.this, R.string.Campos_Pendentes, Toast.LENGTH_SHORT).show();
        } else {
            DadosGlobais dados = new DadosGlobais();
            dados.setNome(Nome);
            dados.setSobreNome(SobreNome);

            Intent abrirproximo = new Intent(NomeSobrenome.this, Nascimento.class);
            startActivity(abrirproximo);
        }
    }
}