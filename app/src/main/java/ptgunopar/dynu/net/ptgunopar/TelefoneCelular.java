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
import ptgunopar.dynu.net.utils.Mascara;

public class TelefoneCelular extends AppCompatActivity {

    private EditText Et_Telefone;
    private EditText Et_Celular;
    private Button Bt_ProximoTelefoneCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone_celular);
        getSupportActionBar().hide();

        Et_Telefone = findViewById(R.id.Et_Telefone);
        Et_Celular = findViewById(R.id.Et_Celular);
        Bt_ProximoTelefoneCelular = findViewById(R.id.Bt_ProximoTelefoneCelular);

        Et_Telefone.setInputType(InputType.TYPE_CLASS_NUMBER);
        Et_Celular.setInputType(InputType.TYPE_CLASS_NUMBER);

        Et_Telefone.addTextChangedListener(Mascara.mask(Et_Telefone, Mascara.FORMAT_TELEFONE));
        Et_Celular.addTextChangedListener(Mascara.mask(Et_Celular, Mascara.FORMAT_CELULAR));
    }

    public void Proximo(View view) {
        String Telefone = Et_Telefone.getText().toString();
        // .replace("(", "")
        // .replace(")", "")
        // .replace("-", "")
        // .replace(" ", "");
        String Celular = Et_Celular.getText().toString();
        //.replace("(", "")
        // .replace(")", "")
        // .replace("-", "")
        // .replace(" ", "");

        if (Telefone.length() != 14) {
            Toast.makeText(TelefoneCelular.this, R.string.Telefone_Invalido, Toast.LENGTH_SHORT).show();
        } else {
            if (Celular.length() != 15) {
                Toast.makeText(TelefoneCelular.this, R.string.Celular_Invalido, Toast.LENGTH_SHORT).show();
            } else {
                DadosGlobais dados = new DadosGlobais();
                dados.setTelefone(Telefone);
                dados.setCelular(Celular);

                Intent abrirproximo = new Intent(TelefoneCelular.this, Email.class);
                startActivity(abrirproximo);
            }
        }
    }
}