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
import ptgunopar.dynu.net.utils.Encriptar;
import ptgunopar.dynu.net.utils.Mascara;
import ptgunopar.dynu.net.utils.ValidaCPF;

public class Entrar extends AppCompatActivity {

    DadosGlobais dados = new DadosGlobais();
    private EditText Et_CPF;
    private EditText Et_Senha;
    private Button Bt_Entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        getSupportActionBar().hide();

        Et_CPF = findViewById(R.id.Et_CPF);
        Et_Senha = findViewById(R.id.Et_Senha);
        Bt_Entrar = findViewById(R.id.Bt_Entrar);

        Et_CPF.setInputType(InputType.TYPE_CLASS_NUMBER);
        Et_CPF.addTextChangedListener(Mascara.mask(Et_CPF, Mascara.FORMAT_CPF));
    }

    public void Entrar(View vire) {
        ValidaCPF validar = new ValidaCPF();
        String CPF = Et_CPF.getText().toString().replace(".", "").replace("-", "");
        if (!validar.ValidarCPF(CPF)) {
            Toast.makeText(Entrar.this, R.string.CPF_Invalido, Toast.LENGTH_SHORT).show();
        } else {
            String Senha = Et_Senha.getText().toString();
            if (Senha.length() < 6) {
                Toast.makeText(Entrar.this, R.string.Senha_Invalida, Toast.LENGTH_SHORT).show();
            } else {
                Encriptar encriptar = new Encriptar();
                String SenhaEncriptada = encriptar.EncriptarSenha(Senha);

                Ion.with(Entrar.this)
                        .load("http://ptgunopar.dynu.net/sistema/entrar.php")
                        .setTimeout(5000)
                        .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                        .setBodyParameter("CPF", CPF)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                try {
                                    String SenhaCadastro = result.get("SENHA").getAsString();
                                    if (SenhaCadastro.length() == 40) {
                                        if (SenhaEncriptada.equals(SenhaCadastro)) {
                                            dados.setCPFLogado(CPF);
                                            Intent abririmoveiscadastrados = new Intent(Entrar.this, ImoveisCadastrados.class);
                                            startActivity(abririmoveiscadastrados);
                                        } else {
                                            Toast.makeText(Entrar.this, R.string.Senha_Incorreta, Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        if (SenhaCadastro.equals("CADASTROINEXISTENTE")) {
                                            Toast.makeText(Entrar.this, R.string.Cadastro_Inexistente, Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } catch (Exception ex) {
                                    try {
                                        String Resposta = result.get("ACESSO").getAsString();
                                        if (Resposta.equals("NEGADO")) {
                                            Toast.makeText(Entrar.this, R.string.App_Desatualizado, Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (Exception ex2) {
                                        Toast.makeText(Entrar.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
            }
        }
    }

    public void onBackPressed() {
        Intent abrirmain = new Intent(Entrar.this, MainActivity.class);
        startActivity(abrirmain);
    }
}