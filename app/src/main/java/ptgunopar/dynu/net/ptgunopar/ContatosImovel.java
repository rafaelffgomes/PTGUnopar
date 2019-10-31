package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import ptgunopar.dynu.net.dados.DadosGlobais;
import ptgunopar.dynu.net.utils.Mascara;

public class ContatosImovel extends AppCompatActivity {

    DadosGlobais dados = new DadosGlobais();
    private EditText Et_ContatoTelefoneImovel;
    private EditText Et_ContatoCelularImovel;
    private EditText Et_ContatoEmailImovel;
    private CheckBox Cb_Telefone;
    private CheckBox Cb_Celular;
    private CheckBox Cb_Email;
    private Button Bt_CadastrarImovel;
    private String CPFLogado = dados.getCPFLogado();
    private String Telefone;
    private String Celular;
    private String Email;
    private String TelefoneCadastrado;
    private String CelularCadastrado;
    private String EmailCadastrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos_imovel);
        getSupportActionBar().hide();

        Et_ContatoTelefoneImovel = findViewById(R.id.Et_ContatoTelefoneImovel);
        Et_ContatoCelularImovel = findViewById(R.id.Et_ContatoCelularImovel);
        Et_ContatoEmailImovel = findViewById(R.id.Et_ContatoEmailImovel);
        Cb_Telefone = findViewById(R.id.Cb_Telefone);
        Cb_Celular = findViewById(R.id.Cb_Celular);
        Cb_Email = findViewById(R.id.Cb_Email);
        Bt_CadastrarImovel = findViewById(R.id.Bt_CadastrarImovel);

        Et_ContatoTelefoneImovel.setInputType(InputType.TYPE_CLASS_NUMBER);
        Et_ContatoCelularImovel.setInputType(InputType.TYPE_CLASS_NUMBER);

        Et_ContatoTelefoneImovel.addTextChangedListener(Mascara.mask(Et_ContatoTelefoneImovel, Mascara.FORMAT_TELEFONE));
        Et_ContatoCelularImovel.addTextChangedListener(Mascara.mask(Et_ContatoCelularImovel, Mascara.FORMAT_CELULAR));

        Ion.with(ContatosImovel.this)
                .load("http://ptgunopar.dynu.net/sistema/get_dados_contatos.php")
                .setTimeout(5000)
                .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                .setBodyParameter("CPFLogado", CPFLogado)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        try {
                            TelefoneCadastrado = result.get("TELEFONE").getAsString();
                            CelularCadastrado = result.get("CELULAR").getAsString();
                            EmailCadastrado = result.get("EMAIL").getAsString();
                        } catch (Exception ex) {
                            Toast.makeText(ContatosImovel.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        Cb_Telefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CompoundButton) view).isChecked()) {
                    Et_ContatoTelefoneImovel.setText(TelefoneCadastrado);
                } else {
                    Et_ContatoTelefoneImovel.setText(null);
                }
            }
        });

        Cb_Celular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CompoundButton) view).isChecked()) {
                    Et_ContatoCelularImovel.setText(CelularCadastrado);
                } else {
                    Et_ContatoCelularImovel.setText(null);
                }
            }
        });

        Cb_Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CompoundButton) view).isChecked()) {
                    Et_ContatoEmailImovel.setText(EmailCadastrado);
                } else {
                    Et_ContatoEmailImovel.setText(null);
                }
            }
        });
    }

    public void CadastrarImovel(View view) {
        Telefone = Et_ContatoTelefoneImovel.getText().toString();
        //.replace("(", "")
        // .replace(")", "")
        // .replace("-", "")
        // .replace(" ", "");
        Celular = Et_ContatoCelularImovel.getText().toString();
        //.replace("(", "")
        // .replace(")", "")
        // .replace("-", "")
        // .replace(" ", "");
        Email = Et_ContatoEmailImovel.getText().toString();

        if (!Telefone.isEmpty() && Telefone.length() != 14) {
            Toast.makeText(ContatosImovel.this, R.string.Telefone_Invalido, Toast.LENGTH_SHORT).show();
        } else {
            if (!Celular.isEmpty() && Celular.length() != 15) {
                Toast.makeText(ContatosImovel.this, R.string.Celular_Invalido, Toast.LENGTH_SHORT).show();
            } else {
                if (!Email.isEmpty()) {
                    if (!Email.contains("@") || !Email.contains(".")) {
                        Toast.makeText(ContatosImovel.this, R.string.Email_Invalido, Toast.LENGTH_SHORT).show();
                    } else {
                        ProsseguirCadastroImovel();
                    }
                } else {
                    ProsseguirCadastroImovel();
                }
            }
        }
    }

    public void ProsseguirCadastroImovel() {

        String Tipo = dados.getTipo();
        String Titulo = dados.getTitulo();
        Integer Quartos = dados.getQuartos();
        Integer Suites = dados.getSuites();
        Integer Banheiros = dados.getBanheiros();
        Integer Vagas = dados.getVagas();
        Integer Area = dados.getArea();
        String Piscina = dados.getPiscina();
        String Cidade = dados.getCidade();
        String Estado = dados.getEstado();
        String Bairro = dados.getBairro();
        String Descricao = dados.getDescricao();
        String ValorSugerido = dados.getValorSugerido();
        String ValorVenda = dados.getValorVenda();

        Ion.with(ContatosImovel.this)
                .load("http://ptgunopar.dynu.net/sistema/cadastrar_imovel.php")
                .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                .setBodyParameter("CPFLogado", CPFLogado)
                .setBodyParameter("Tipo", Tipo)
                .setBodyParameter("Titulo", Titulo)
                .setBodyParameter("Quartos", Quartos.toString())
                .setBodyParameter("Suites", Suites.toString())
                .setBodyParameter("Banheiros", Banheiros.toString())
                .setBodyParameter("Vagas", Vagas.toString())
                .setBodyParameter("Area", Area.toString())
                .setBodyParameter("Piscina", Piscina)
                .setBodyParameter("Cidade", Cidade)
                .setBodyParameter("Estado", Estado)
                .setBodyParameter("Bairro", Bairro)
                .setBodyParameter("Descricao", Descricao)
                .setBodyParameter("ValorSugerido", ValorSugerido)
                .setBodyParameter("ValorVenda", ValorVenda)
                .setBodyParameter("Telefone", Telefone)
                .setBodyParameter("Celular", Celular)
                .setBodyParameter("Email", Email)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        try {
                            if (result.get("CADASTRO").getAsString().equals("SUCESSO")) {
                                Toast.makeText(ContatosImovel.this, R.string.Cadastro_Sucesso, Toast.LENGTH_SHORT).show();
                                Intent abririmoveiscadastrados = new Intent(ContatosImovel.this, ImoveisCadastrados.class);
                                startActivity(abririmoveiscadastrados);
                            } else {
                                Toast.makeText(ContatosImovel.this, R.string.Cadastro_Erro, Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception ex) {
                            Toast.makeText(ContatosImovel.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}