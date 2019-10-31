package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ptgunopar.dynu.net.dados.DadosGlobais;

public class DadosImovel extends AppCompatActivity {

    private EditText Et_QuartosImovel;
    private EditText Et_SuitesImovel;
    private EditText Et_BanheirosImovel;
    private Button Bt_ProximoDadosImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_imovel);
        getSupportActionBar().hide();

        Et_QuartosImovel = findViewById(R.id.Et_QuartosImovel);
        Et_SuitesImovel = findViewById(R.id.Et_SuitesImovel);
        Et_BanheirosImovel = findViewById(R.id.Et_BanheirosImovel);
        Bt_ProximoDadosImovel = findViewById(R.id.Bt_ProximoDadosImovel);

        Et_QuartosImovel.setInputType(InputType.TYPE_CLASS_NUMBER);
        Et_SuitesImovel.setInputType(InputType.TYPE_CLASS_NUMBER);
        Et_BanheirosImovel.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    public void Proximo(View view) {
        String Quartos = Et_QuartosImovel.getText().toString();
        String Suites = Et_SuitesImovel.getText().toString();
        String Banheiros = Et_BanheirosImovel.getText().toString();

        if ((Quartos.isEmpty()) || (Suites.isEmpty()) || (Banheiros.isEmpty())) {
            Toast.makeText(DadosImovel.this, R.string.Campos_Pendentes, Toast.LENGTH_SHORT).show();
        } else {
            Integer IntQuartos = Integer.parseInt(Quartos);
            Integer IntSuites = Integer.parseInt(Suites);
            Integer IntBanheiros = Integer.parseInt(Banheiros);

            DadosGlobais dados = new DadosGlobais();
            dados.setQuartos(IntQuartos);
            dados.setSuites(IntSuites);
            dados.setBanheiros(IntBanheiros);

            Intent abrirproximo = new Intent(DadosImovel.this, DadosImovel2.class);
            startActivity(abrirproximo);
        }
    }
}