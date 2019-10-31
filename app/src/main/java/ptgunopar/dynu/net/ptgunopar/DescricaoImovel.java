package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ptgunopar.dynu.net.dados.DadosGlobais;

public class DescricaoImovel extends AppCompatActivity {

    private EditText Et_DescricaoImovel;
    private Button Bt_ProximoDescricaoImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_imovel);
        getSupportActionBar().hide();

        Et_DescricaoImovel = findViewById(R.id.Et_DescricaoImovel);
        Bt_ProximoDescricaoImovel = findViewById(R.id.Bt_ProximoDescricaoImovel);
    }

    public void Proximo(View view) {
        String Descricao = Et_DescricaoImovel.getText().toString();

        if (Descricao.isEmpty()) {
            Toast.makeText(DescricaoImovel.this, R.string.Campos_Pendentes, Toast.LENGTH_SHORT).show();
        } else {
            DadosGlobais dados = new DadosGlobais();
            dados.setDescricao(Descricao);

            Intent abrirproximo = new Intent(DescricaoImovel.this, ValorImovel.class);
            startActivity(abrirproximo);
        }
    }
}