package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ptgunopar.dynu.net.dados.DadosGlobais;

public class CadastrarNovo extends AppCompatActivity {

    private Spinner Sp_TipoImovel;
    private EditText Et_TituloImovel;
    private Button Bt_ProximoTipoImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_novo);

        Sp_TipoImovel = findViewById(R.id.Sp_TipoImovel);
        Et_TituloImovel = findViewById(R.id.Et_TituloImovel);
        Bt_ProximoTipoImovel = findViewById(R.id.Bt_CadastrarNovo);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Sp_TipoImovel, R.layout.layout_spinner);
        Sp_TipoImovel.setAdapter(adapter);
    }

    public void Proximo(View view) {
        String Tipo = Sp_TipoImovel.getSelectedItem().toString();
        String Titulo = Et_TituloImovel.getText().toString();

        if (Titulo.isEmpty()) {
            Toast.makeText(CadastrarNovo.this, R.string.Campos_Pendentes, Toast.LENGTH_SHORT).show();
        } else {
            DadosGlobais dados = new DadosGlobais();
            dados.setTipo(Tipo);
            dados.setTitulo(Titulo);

            Intent abrirproximo = new Intent(CadastrarNovo.this, DadosImovel.class);
            startActivity(abrirproximo);
        }
    }
}