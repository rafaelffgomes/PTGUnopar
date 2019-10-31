package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import ptgunopar.dynu.net.dados.DadosGlobais;
import ptgunopar.dynu.net.utils.Mascara;
import ptgunopar.dynu.net.utils.ValidaCPF;

public class CriarConta extends AppCompatActivity {

    DadosGlobais dados = new DadosGlobais();
    private EditText Et_CPF;
    private Button Bt_Proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criarconta);
        getSupportActionBar().hide();

        Et_CPF = findViewById(R.id.Et_CPF);
        Bt_Proximo = findViewById(R.id.Bt_ProximoCriarConta);

        Et_CPF.setInputType(InputType.TYPE_CLASS_NUMBER);
        Et_CPF.addTextChangedListener(Mascara.mask(Et_CPF, Mascara.FORMAT_CPF));
    }

    public void Proximo(View view) {
        ValidaCPF validar = new ValidaCPF();
        String CPF = Et_CPF.getText().toString().replace(".", "").replace("-", "");
        if (!validar.ValidarCPF(CPF)) {
            Toast.makeText(CriarConta.this, R.string.CPF_Invalido, Toast.LENGTH_SHORT).show();
        } else {
            Ion.with(CriarConta.this)
                    .load("http://ptgunopar.dynu.net/sistema/cadastrar_usuario.php")
                    .setTimeout(5000)
                    .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                    .setBodyParameter("CPF", CPF)
                    .asJsonObject()
                    .setCallback(new FutureCallback<JsonObject>() {
                        @Override
                        public void onCompleted(Exception e, JsonObject result) {
                            try {
                                if (result.get("CADASTRO").getAsString().equals("CADASTROEXISTENTE")) {
                                    Toast.makeText(CriarConta.this, R.string.Cadastro_Existente, Toast.LENGTH_SHORT).show();
                                } else {
                                    dados.setCPF(Et_CPF.getText().toString().replace(".", "").replace("-", ""));

                                    Intent abrirproximo = new Intent(CriarConta.this, NomeSobrenome.class);
                                    startActivity(abrirproximo);
                                }
                            } catch (Exception ex) {
                                Toast.makeText(CriarConta.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}