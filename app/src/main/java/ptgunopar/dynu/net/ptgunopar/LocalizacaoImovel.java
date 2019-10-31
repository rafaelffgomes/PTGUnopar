package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ptgunopar.dynu.net.dados.DadosGlobais;

public class LocalizacaoImovel extends AppCompatActivity {

    private EditText Et_CidadeImovel;
    private EditText Et_BairroImovel;
    private Spinner Sp_EstadoImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao_imovel);
        getSupportActionBar().hide();

        Et_CidadeImovel = findViewById(R.id.Et_CidadeImovel);
        Et_BairroImovel = findViewById(R.id.Et_BairroImovel);
        Sp_EstadoImovel = findViewById(R.id.Sp_EstadoImovel);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Sp_LocalizacaoImovel, R.layout.layout_spinner);
        Sp_EstadoImovel.setAdapter(adapter);
        Sp_EstadoImovel.setSelection(12);

        Et_CidadeImovel.setEnabled(false);
        Sp_EstadoImovel.setEnabled(false);
    }

    public void Proximo(View view) {
        String Cidade = Et_CidadeImovel.getText().toString();
        String Bairro = Et_BairroImovel.getText().toString();
        String Estado = Sp_EstadoImovel.getSelectedItem().toString();

        if (Cidade.isEmpty() || Bairro.isEmpty()) {
            Toast.makeText(LocalizacaoImovel.this, R.string.Campos_Pendentes, Toast.LENGTH_SHORT).show();
        } else {
            DadosGlobais dados = new DadosGlobais();
            dados.setCidade(Cidade);
            dados.setBairro(Bairro);
            dados.setEstado(Estado);

            Intent abrirproximo = new Intent(LocalizacaoImovel.this, DescricaoImovel.class);
            startActivity(abrirproximo);
        }
    }
}