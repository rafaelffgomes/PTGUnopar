package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ptgunopar.dynu.net.dados.DadosGlobais;

public class DadosImovel2 extends AppCompatActivity {

    private EditText Et_VagasImovel;
    private EditText Et_AreaImovel;
    private Spinner Sp_PiscinaImovel;
    private Button Bt_ProximoDadosImovel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_imovel2);
        getSupportActionBar().hide();

        Et_VagasImovel = findViewById(R.id.Et_VagasImovel);
        Et_AreaImovel = findViewById(R.id.Et_AreaImovel);
        Sp_PiscinaImovel = findViewById(R.id.Sp_PiscinaImovel);
        Bt_ProximoDadosImovel2 = findViewById(R.id.Bt_ProximoDadosImovel2);

        Et_VagasImovel.setInputType(InputType.TYPE_CLASS_NUMBER);
        Et_AreaImovel.setInputType(InputType.TYPE_CLASS_NUMBER);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Sp_PiscinaImovel, R.layout.layout_spinner);
        Sp_PiscinaImovel.setAdapter(adapter);
        Sp_PiscinaImovel.setSelection(1);
    }

    public void Proximo(View view) {
        String Vagas = Et_VagasImovel.getText().toString();
        String Area = Et_AreaImovel.getText().toString();

        if ((Vagas.isEmpty()) || (Area.isEmpty())) {
            Toast.makeText(DadosImovel2.this, R.string.Campos_Pendentes, Toast.LENGTH_SHORT).show();
        } else {
            Integer IntVagas = Integer.parseInt(Vagas);
            Integer IntArea = Integer.parseInt(Area);
            String Piscina = Sp_PiscinaImovel.getSelectedItem().toString();

            DadosGlobais dados = new DadosGlobais();
            dados.setVagas(IntVagas);
            dados.setArea(IntArea);
            dados.setPiscina(Piscina);

            Intent abrirproximo = new Intent(DadosImovel2.this, LocalizacaoImovel.class);
            startActivity(abrirproximo);
        }
    }
}