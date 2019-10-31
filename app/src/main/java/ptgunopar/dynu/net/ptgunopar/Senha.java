package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
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

public class Senha extends AppCompatActivity {

    private EditText Et_Senha;
    private EditText Et_ConfirmacaoSenha;
    private Button Bt_CriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);
        getSupportActionBar().hide();

        Et_Senha = findViewById(R.id.Et_Senha);
        Et_ConfirmacaoSenha = findViewById(R.id.Et_ConfirmacaoSenha);
        Bt_CriarConta = findViewById(R.id.Bt_CriarConta);
    }

    public void CriarConta(View view) {
        String Senha = Et_Senha.getText().toString();
        String ConfirmacaoSenha = Et_ConfirmacaoSenha.getText().toString();
        if ((Senha.length() < 6) || (Senha.length() > 10)) {
            Toast.makeText(Senha.this, R.string.DigitosSenha, Toast.LENGTH_SHORT).show();
        } else {
            if (!Senha.equals(ConfirmacaoSenha)) {
                Toast.makeText(Senha.this, R.string.ConfirmacaoSenha, Toast.LENGTH_SHORT).show();
            } else {
                DadosGlobais dados = new DadosGlobais();
                Encriptar encriptar = new Encriptar();
                String CPF = dados.getCPF();
                String SenhaEncriptada = encriptar.EncriptarSenha(Senha);
                String Nome = dados.getNome();
                String SobreNome = dados.getSobreNome();
                String Nascimento = dados.getNascimento();
                String Telefone = dados.getTelefone();
                String Celular = dados.getCelular();
                String Email = dados.getEmail();

                Ion.with(Senha.this)
                        .load("http://ptgunopar.dynu.net/sistema/cadastrar_usuario.php")
                        .setTimeout(5000)
                        .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                        .setBodyParameter("CPF", CPF)
                        .setBodyParameter("Senha", SenhaEncriptada)
                        .setBodyParameter("Nome", Nome)
                        .setBodyParameter("SobreNome", SobreNome)
                        .setBodyParameter("Nascimento", Nascimento)
                        .setBodyParameter("Telefone", Telefone)
                        .setBodyParameter("Celular", Celular)
                        .setBodyParameter("Email", Email)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                try {
                                    if (result.get("CADASTRO").getAsString().equals("SUCESSO")) {
                                        Toast.makeText(Senha.this, R.string.Cadastro_Sucesso, Toast.LENGTH_SHORT).show();
                                        Intent abrirentrar = new Intent(Senha.this, Entrar.class);
                                        startActivity(abrirentrar);
                                    } else {
                                        Toast.makeText(Senha.this, R.string.Cadastro_Erro, Toast.LENGTH_SHORT).show();
                                    }
                                } catch (Exception ex) {
                                    Toast.makeText(Senha.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        }
    }
}